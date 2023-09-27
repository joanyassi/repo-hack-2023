package com.barclays.repohack.Barclaysrepohack.io.swagger.service;

import com.barclays.repohack.Barclaysrepohack.io.swagger.entities.Trade;
import com.barclays.repohack.Barclaysrepohack.io.swagger.entities.TradeEvent;
import com.barclays.repohack.Barclaysrepohack.io.swagger.model.*;
import com.barclays.repohack.Barclaysrepohack.io.swagger.repo.TradeEventRepository;
import com.barclays.repohack.Barclaysrepohack.io.swagger.repo.TradeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsAsyncClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import springfox.documentation.service.Header;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Service
public class RepoTradesService {

    private final RestTemplate restTemplate;
    private TradeRepository tradeRepository;

    private TradeEventRepository tradeEventRepository;

    @Autowired
    ResourceLoader resourceLoader;


    @Autowired
    public RepoTradesService(RestTemplate restTemplate, TradeRepository tradeRepository, TradeEventRepository tradeEventRepository){
        this.restTemplate = restTemplate;
        this.tradeRepository = tradeRepository;
        this.tradeEventRepository = tradeEventRepository;
    }

    public ResponseEntity<String>  createTradeExecutionRequest(HttpEntity requestEntity, RepoTradeExecutionSubmissionRequest request, String buyer, String seller) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        ResponseEntity<String> response =  restTemplate.exchange(
                   "https://repohack2023.nayaone.com/repoTrades/execution", HttpMethod.POST, requestEntity, String.class);
        RepoTradeSubmissionResponse repoTradeSubmissionResponse = objectMapper.readValue(response.getBody(), RepoTradeSubmissionResponse.class);
        //ResponseEntity<RepoTradeSubmissionResponse> response = tradeStatus("UC2Q0EKXFH6260", "TRADE_ACCEPTED");
        if(HttpStatus.valueOf(response.getStatusCodeValue()).is2xxSuccessful()) {
           Trade trade = tradeRepository.findByTradeIdEquals(repoTradeSubmissionResponse.getTradeId());
           if(trade == null){
               tradeRepository.save(new Trade(repoTradeSubmissionResponse.getTradeId(), buyer, seller));
           }
           else{
               trade.setBuyer(buyer);
               trade.setSeller(seller);
               tradeRepository.save(trade);
           }

           saveOrUpdateTradeCycle(repoTradeSubmissionResponse);
       }
        return response;
    }

    public ResponseEntity<RepoTradeSubmissionResponse>  postSettlementRequest(HttpEntity<SettlementRequestBody> requestEntity, String tradeId){
        ResponseEntity<RepoTradeSubmissionResponse> response =  restTemplate.exchange(
                "https://repohack2023.nayaone.com/repoTrades/settlement", HttpMethod.POST, requestEntity, RepoTradeSubmissionResponse.class);
        //ResponseEntity<RepoTradeSubmissionResponse> response = tradeStatus("UC2Q0EKXFH6260", "TRADE_SETTLED");
        if(HttpStatus.valueOf(response.getStatusCodeValue()).is2xxSuccessful()) {
            RepoTradeSubmissionResponse repoTradeResponse = response.getBody();
            assert repoTradeResponse != null;
            saveOrUpdateTradeCycle(response.getBody());
        }
        return response;
    }

    public ResponseEntity<String>  tradeClearing(HttpEntity<ClearingRequestBody> requestEntity, String tradeId){

        //ResponseEntity<RepoTradeSubmissionResponse> response = tradeStatus("UC2Q0EKXFH6260","TRADE_CLEARED");
        HttpHeaders httpHeaders = requestEntity.getHeaders();
        TradeBusinessEventsQueryRequest tradeBusinessRequest = new TradeBusinessEventsQueryRequest();
        tradeBusinessRequest.setTradeId(tradeId);
        tradeBusinessRequest.setFmi("TRADE_MATCHING_SERVICE");
        tradeBusinessRequest.fromDate("2023-09-27T07:27:08.943Z");
        tradeBusinessRequest.toDate("2023-09-28T22:27:08.943Z");
        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = null;
        try {
            jsonStr = Obj.writeValueAsString(tradeBusinessRequest);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        HttpEntity<String> tradeBusinessEventRequest =
                new HttpEntity<>(jsonStr, httpHeaders);
        TradeBusinessEventsQueryResponse businessEvents = null;
        List<BusinessEventData> businessEventData = null;
        JsonNode data= null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String response  = getBusinessEvents(tradeBusinessEventRequest).getBody();
            businessEvents = objectMapper.readValue(response, TradeBusinessEventsQueryResponse.class);

            assert businessEvents != null;
            businessEventData = businessEvents.getTradeMatchingService();
            data = businessEventData.get(0).getBusinessEvents().get(0).getBusinessEventData();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
         /* ResponseEntity<RepoTradeSubmissionResponse> response =  restTemplate.exchange(
                "https://repohack2023.nayaone.com/repoTrades/clearing", HttpMethod.POST, requestEntity, RepoTradeSubmissionResponse.class);*/
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json;
        try {
            json = ow.writeValueAsString(data);
            json = "{\n" +
                    "  \"businessEventData\":" + json + "}";
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        HttpEntity<String> tradeClearingEventRequest =
                new HttpEntity<>(json, httpHeaders);
        ResponseEntity<RepoTradeSubmissionResponse> response =  restTemplate.exchange(
                "https://repohack2023.nayaone.com/repoTrades/clearing", HttpMethod.POST, tradeClearingEventRequest, RepoTradeSubmissionResponse.class);
        if(HttpStatus.valueOf(response.getStatusCodeValue()).is2xxSuccessful()) {
            RepoTradeSubmissionResponse repoTradeResponse = response.getBody();
            assert repoTradeResponse != null;
            saveOrUpdateTradeCycle(repoTradeResponse);
        }
        HttpEntity httpEntity = new HttpEntity<>(httpHeaders);
        return getWorkflowEvents(httpEntity, Objects.requireNonNull(response.getBody()).getTradeId(), "TRADE_CLEARING_SERVICE");
    }
    public ResponseEntity<String> getBusinessEvents (HttpEntity<String> requestEntity) throws IOException {

        /*ObjectMapper objectMapper = new ObjectMapper();
        Resource classPathResource = resourceLoader.getResource("classpath:tradeBusinessEventQueryResponse.json");
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        TradeBusinessEventsQueryResponse tradeBusinessEventsJson = objectMapper.readValue(new File(classPathResource.getURI()), TradeBusinessEventsQueryResponse.class);
        ResponseEntity<TradeBusinessEventsQueryResponse> response = tradeBusinessEvents(tradeBusinessEventsJson);
        */
        return restTemplate.exchange(
                "https://repohack2023.nayaone.com/repoTrades/tradeBusinessEventsQuery", HttpMethod.POST, requestEntity, String.class);

    }

    public ResponseEntity<String> getWorkflowEvents(HttpEntity requestEntity, String tradeId, String fmi){

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString("https://repohack2023.nayaone.com/repoTrades/tradeWorkflowStatus");
        URI uri = uriComponentsBuilder.queryParam("tradeId", tradeId).queryParam("fmi", fmi).build().toUri();
        ResponseEntity<String> response = restTemplate.exchange(
                uri, HttpMethod.GET, requestEntity, String.class);
        //Trade trade = tradeRepository.findByTradeIdEquals(tradeId);
        //List<TradeEvent> tradeEvent = tradeEventRepository.findByTradeId(trade.getId());
        /*for(TradeEvent te: tradeEvent){
            List<WorkflowEventData> wfedList = new ArrayList<>();
            if(te.getEvent().equals("TRADE_ACCEPTED")){
                WorkflowEventData wfed = new WorkflowEventData();
                wfed.setWorkflowEvents(getWorkflowEventDataList(te));
                wfedList.add(wfed);
                response.setTradeMatchingService(wfedList);
            }
            if(te.getEvent().equals("TRADE_CLEARED")){
                WorkflowEventData wfed = new WorkflowEventData();
                wfed.setWorkflowEvents(getWorkflowEventDataList(te));
                wfedList.add(wfed);
                response.setTradeMatchingService(wfedList);
            }
            if(te.getEvent().equals("TRADE_SETTLED")){
                WorkflowEventData wfed = new WorkflowEventData();
                wfed.setWorkflowEvents(getWorkflowEventDataList(te));
                wfedList.add(wfed);
                response.setTradeMatchingService(wfedList);
            }

        }*/

        return response;
        /*return restTemplate.exchange(
                uri, HttpMethod.GET, requestEntity, TradeWorkflowStatusResponse.class);*/
    }

    public void saveOrUpdateTradeCycle(RepoTradeSubmissionResponse repoTradeResponse){
        Trade trade = tradeRepository.findByTradeIdEquals(repoTradeResponse.getTradeId());
        if(trade !=null){
            TradeEvent tradeEvent = new TradeEvent();
            tradeEvent.setTradeId(trade);
            tradeEvent.setParticipant(trade.getBuyer() + " & " + trade.getSeller());
            tradeEvent.setEvent(repoTradeResponse.getTradeStatus());
            tradeEventRepository.save(tradeEvent);
        }
    }

    public static ResponseEntity<RepoTradeSubmissionResponse> tradeStatus(String tradeId, String tradeStatus) {
        RepoTradeSubmissionResponse response = new RepoTradeSubmissionResponse();
        response.setTradeId(tradeId);
        response.setTradeStatus(tradeStatus);
        return ResponseEntity.ok()
                .body(response);


    }

    public static ResponseEntity<TradeBusinessEventsQueryResponse> tradeBusinessEvents(TradeBusinessEventsQueryResponse tradeBusinessEventsJson){
        TradeBusinessEventsQueryResponse response = new TradeBusinessEventsQueryResponse();
        response.setTradeMatchingService(tradeBusinessEventsJson.getTradeMatchingService());
        response.setTradeClearingService(tradeBusinessEventsJson.getTradeClearingService());
        response.setTradeSettlementService(tradeBusinessEventsJson.getTradeSettlementService());
        return ResponseEntity.ok()
                .body(response);
    }

    public static ResponseEntity<TradeWorkflowStatusResponse> tradeWorkFlowEvents(TradeWorkflowStatusResponse tradeWorkflowStatusResponse){

        TradeWorkflowStatusResponse response = new TradeWorkflowStatusResponse();
        response.setTradeMatchingService(tradeWorkflowStatusResponse.getTradeMatchingService());
        response.setTradeClearingService(tradeWorkflowStatusResponse.getTradeClearingService());
        response.setTradeSettlementService(tradeWorkflowStatusResponse.getTradeSettlementService());
        return ResponseEntity.ok()
                .body(response);
    }

    public List<Trade> getTradesList(String loggedInUser){
        return tradeRepository.getTradesforLoggedInUser(loggedInUser);
    }

    public static List<WorkflowEvent> getWorkflowEventDataList(TradeEvent te){
        WorkflowEvent wfe = new WorkflowEvent();
        wfe.setEventTimeStamp(te.getTimestamp());
        wfe.setTradeStatus(te.getEvent());
        wfe.setTradeMatchingStatus(te.getEvent());
        List<WorkflowEvent> wfeList = new ArrayList<>();
        wfeList.add(wfe);
        return wfeList;
    }

}

