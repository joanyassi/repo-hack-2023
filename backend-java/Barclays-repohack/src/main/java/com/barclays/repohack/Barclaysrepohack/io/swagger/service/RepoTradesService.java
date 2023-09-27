package com.barclays.repohack.Barclaysrepohack.io.swagger.service;

import com.barclays.repohack.Barclaysrepohack.io.swagger.entities.Trade;
import com.barclays.repohack.Barclaysrepohack.io.swagger.entities.TradeEvent;
import com.barclays.repohack.Barclaysrepohack.io.swagger.model.*;
import com.barclays.repohack.Barclaysrepohack.io.swagger.repo.TradeEventRepository;
import com.barclays.repohack.Barclaysrepohack.io.swagger.repo.TradeRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.net.URI;
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

    public ResponseEntity<RepoTradeSubmissionResponse>  createTradeExecutionRequest(HttpEntity<RepoTradeExecutionSubmissionRequest> requestEntity){




      /* ResponseEntity<RepoTradeSubmissionResponse> response =  restTemplate.exchange(
                   "https://repohack2023.nayaone.com/repoTrades/execution", HttpMethod.POST, requestEntity, RepoTradeSubmissionResponse.class);*/
        ResponseEntity<RepoTradeSubmissionResponse> response = tradeStatus("UC2Q0EKXFH6260", "TRADE_ACCEPTED");
        if(HttpStatus.valueOf(response.getStatusCodeValue()).is2xxSuccessful()) {
           tradeRepository.save(new Trade(Objects.requireNonNull(response.getBody()).getTradeId(), Objects.requireNonNull(requestEntity.getBody()).getBuyer().getBuyerName(), Objects.requireNonNull(requestEntity.getBody()).getSeller().getSellerName()));
           saveOrUpdateTradeCycle(response.getBody());

       }
        return response;
    }

    public ResponseEntity<RepoTradeSubmissionResponse>  postSettlementRequest(HttpEntity<SettlementRequestBody> requestEntity){
        /*ResponseEntity<RepoTradeSubmissionResponse> response =  restTemplate.exchange(
                "https://repohack2023.nayaone.com/repoTrades/settlement", HttpMethod.POST, requestEntity, RepoTradeSubmissionResponse.class);*/
        ResponseEntity<RepoTradeSubmissionResponse> response = tradeStatus("UC2Q0EKXFH6260", "TRADE_SETTLED");
        if(HttpStatus.valueOf(response.getStatusCodeValue()).is2xxSuccessful()) {
            RepoTradeSubmissionResponse repoTradeResponse = response.getBody();
            assert repoTradeResponse != null;
            saveOrUpdateTradeCycle(response.getBody());
        }
        return response;
    }

    public ResponseEntity<RepoTradeSubmissionResponse>  tradeClearing(HttpEntity<ClearingRequestBody> requestEntity){
       /* ResponseEntity<RepoTradeSubmissionResponse> response =  restTemplate.exchange(
                "https://repohack2023.nayaone.com/repoTrades/clearing", HttpMethod.POST, requestEntity, RepoTradeSubmissionResponse.class);*/
        ResponseEntity<RepoTradeSubmissionResponse> response = tradeStatus("UC2Q0EKXFH6260","TRADE_CLEARED");
        if(HttpStatus.valueOf(response.getStatusCodeValue()).is2xxSuccessful()) {
            RepoTradeSubmissionResponse repoTradeResponse = response.getBody();
            assert repoTradeResponse != null;
            saveOrUpdateTradeCycle(repoTradeResponse);
        }
        return response;
    }
    public ResponseEntity<TradeBusinessEventsQueryResponse> getBusinessEvents (HttpEntity<TradeBusinessEventsQueryRequest> requestEntity) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Resource classPathResource = resourceLoader.getResource("classpath:tradeBusinessEventQueryResponse.json");
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        TradeBusinessEventsQueryResponse tradeBusinessEventsJson = objectMapper.readValue(new File(classPathResource.getURI()), TradeBusinessEventsQueryResponse.class);
        ResponseEntity<TradeBusinessEventsQueryResponse> response = tradeBusinessEvents(tradeBusinessEventsJson);
        /*return restTemplate.exchange(
                "https://repohack2023.nayaone.com/repoTrades/tradeBusinessEventsQuery", HttpMethod.POST, requestEntity, TradeBusinessEventsQueryResponse.class);*/
        return response;
    }

    public ResponseEntity<TradeWorkflowStatusResponse> getWorkflowEvents(HttpEntity requestEntity, String tradeId, String fmi){

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString("https://repohack2023.nayaone.com/repoTrades/tradeWorkflowStatus");
        URI uri = uriComponentsBuilder.queryParam("tradeId", tradeId).queryParam("fmi", fmi).build().toUri();
        Trade trade = tradeRepository.findByTradeIdEquals(tradeId);
        List<TradeEvent> tradeEvent = tradeEventRepository.findByTradeId(trade.getId());
        TradeWorkflowStatusResponse response = new TradeWorkflowStatusResponse();
        for(TradeEvent te: tradeEvent){
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

        }

        return ResponseEntity.ok()
                .body(response);
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

    public List<Trade> getTradesList(){
        return tradeRepository.findAll();
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

