package com.barclays.repohack.Barclaysrepohack.io.swagger.api;

import com.barclays.repohack.Barclaysrepohack.io.swagger.entities.Trade;
import com.barclays.repohack.Barclaysrepohack.io.swagger.model.*;
import com.barclays.repohack.Barclaysrepohack.io.swagger.service.RepoTradesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RepoTradesApiController implements RepoTradesApi {

    private static final Logger log = LoggerFactory.getLogger(RepoTradesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final RepoTradesService repoTradesService;

    @org.springframework.beans.factory.annotation.Autowired
    public RepoTradesApiController(ObjectMapper objectMapper, HttpServletRequest request, RepoTradesService repoTradesService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.repoTradesService = repoTradesService;
    }

    public ResponseEntity<TradeBusinessEventsQueryResponse> getBusinessEvents(@Parameter(in = ParameterIn.HEADER, description = "Unique request identifier for the request." ,required=true,schema=@Schema()) @RequestHeader(value="x-api-request-id", required=true) UUID xApiRequestId,@Parameter(in = ParameterIn.HEADER, description = "Unique team identifier provided to your team." ,required=true,schema=@Schema()) @RequestHeader(value="x-participant-id", required=true) String xParticipantId,@Parameter(in = ParameterIn.HEADER, description = "Name of the party retrieving the trade(s) data. Possible values CLIENT01,CLIENT02,CLIENT03 OR DEALER01,DEALER02 OR CCP01 for cleared trades." ,required=true,schema=@Schema()) @RequestHeader(value="x-financial-member-id", required=true) String xFinancialMemberId,@Parameter(in = ParameterIn.HEADER, description = "API authorization key provided to your team." ,required=true,schema=@Schema()) @RequestHeader(value="x-api-key", required=true) String xApiKey,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody TradeBusinessEventsQueryRequest body,@Parameter(in = ParameterIn.HEADER, description = "Date on which the trade(s) was processed at the FMIs. The value should be specified in ISO date format(yyyy-MM-dd)." ,schema=@Schema()) @RequestHeader(value="x-simulation-date", required=false) String xSimulationDate) throws IOException {
            HttpHeaders headers = new HttpHeaders();
            headers.set("x-participant-id", xParticipantId);
            headers.set("x-api-key", xApiKey);
            headers.set("x-api-request-id", String.valueOf(xApiRequestId));
            headers.set("x-financial-member-id", xFinancialMemberId);
            headers.set("x-simulation-date", xSimulationDate);
            HttpEntity<TradeBusinessEventsQueryRequest> requestEntity = new HttpEntity<>(body, headers);
            return repoTradesService.getBusinessEvents(requestEntity);
    }

    public ResponseEntity<TradeWorkflowStatusResponse> getWorkflowEvents(@Parameter(in = ParameterIn.HEADER, description = "Unique request identifier for the request." ,required=true,schema=@Schema()) @RequestHeader(value="x-api-request-id", required=true) UUID xApiRequestId,@Parameter(in = ParameterIn.HEADER, description = "Unique team identifier provided to your team." ,required=true,schema=@Schema()) @RequestHeader(value="x-participant-id", required=true) String xParticipantId,@Parameter(in = ParameterIn.HEADER, description = "Name of the party retrieving the workflow statuses for its trade(s) processed at the FMIs. Possible values are CLIENT01,CLIENT02,CLIENT03 OR DEALER01,DEALER02 OR CCP01 for cleared trades." ,required=true,schema=@Schema()) @RequestHeader(value="x-financial-member-id", required=true) String xFinancialMemberId,@Parameter(in = ParameterIn.HEADER, description = "API authorization key provided to your team." ,required=true,schema=@Schema()) @RequestHeader(value="x-api-key", required=true) String xApiKey,@Parameter(in = ParameterIn.QUERY, description = "Unique identifier for the trade." ,schema=@Schema()) @Valid @RequestParam(value = "tradeId", required = true) String tradeId,@Parameter(in = ParameterIn.QUERY, description = "Name of the financial market infrastructure for which you will like to pull the trades details. Possible values are: TRADE_MATCHING_SERVICE, TRADE_CLEARING_SERVICE, TRADE_SETTLEMENT_SERVICE" ,schema=@Schema()) @Valid  @RequestParam(value = "fmi", required = true) String fmi) {
            HttpHeaders headers = new HttpHeaders();
            headers.set("x-participant-id", xParticipantId);
            headers.set("x-api-key", xApiKey);
            headers.set("x-api-request-id", String.valueOf(xApiRequestId));
            headers.set("x-financial-member-id", xFinancialMemberId);
            HttpEntity httpEntity = new HttpEntity<>(headers);
            return repoTradesService.getWorkflowEvents(httpEntity, tradeId, fmi);

    }

    public ResponseEntity<String> postExecutionRequest(@Parameter(in = ParameterIn.HEADER, description = "Unique request identifier for the request." ,required=true,schema=@Schema()) @RequestHeader(value="x-api-request-id", required=true) UUID xApiRequestId,@Parameter(in = ParameterIn.HEADER, description = "Unique team identifier provided to your team." ,required=true,schema=@Schema()) @RequestHeader(value="x-participant-id", required=true) String xParticipantId,@Parameter(in = ParameterIn.HEADER, description = "Name of the party submitting the trade (should match with the value specified in the input trade data). Possible values are CLIENT01,CLIENT02,CLIENT03 OR DEALER01,DEALER02." ,required=true,schema=@Schema()) @RequestHeader(value="x-financial-member-id", required=true) String xFinancialMemberId,@Parameter(in = ParameterIn.HEADER, description = "API authorization key provided to your team." ,required=true,schema=@Schema()) @RequestHeader(value="x-api-key", required=true) String xApiKey,@Parameter(in = ParameterIn.HEADER, description = "Date on which the trade will be submitted for processing to the FMI. Note that this parameter enables you to fast forward through the trade lifecycle for the purpose of the hackathon. The value must be specified in ISO date format(yyyy-MM-dd)." ,required=true,schema=@Schema()) @RequestHeader(value="x-simulation-date", required=true) String xSimulationDate,@Parameter(in = ParameterIn.DEFAULT, description = "Repo Trade Execution Request", required=true, schema=@Schema()) @Valid @RequestBody JsonNode body) throws JsonProcessingException {
            HttpHeaders headers = new HttpHeaders();
            headers.set("x-participant-id", xParticipantId);
            headers.set("x-api-key", xApiKey);
            headers.set("x-api-request-id", String.valueOf(xApiRequestId));
            headers.set("x-financial-member-id", xFinancialMemberId);
            headers.set("x-simulation-date", xSimulationDate);
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            HttpEntity<String> requestEntity =
                        new HttpEntity<>(body.toString(), headers);
        ObjectMapper jsonObjectMapper = new ObjectMapper();
        RepoTradeExecutionSubmissionRequest newJsonNode = jsonObjectMapper.treeToValue(body, RepoTradeExecutionSubmissionRequest.class);

        return repoTradesService.createTradeExecutionRequest(requestEntity, newJsonNode);
    }

    public ResponseEntity<RepoTradeSubmissionResponse> postSettlementRequest(@Parameter(in = ParameterIn.HEADER, description = "Unique request identifier for the request." ,required=true,schema=@Schema()) @RequestHeader(value="x-api-request-id", required=true) UUID xApiRequestId,@Parameter(in = ParameterIn.HEADER, description = "Unique team identifier provided to your team." ,required=true,schema=@Schema()) @RequestHeader(value="x-participant-id", required=true) String xParticipantId,@Parameter(in = ParameterIn.HEADER, description = "Name of the party submitting the trade (should match with the value specified in the input business event). Possible values are CLIENT01,CLIENT02,CLIENT03 OR DEALER01,DEALER02 OR CCP01 for cleared trades." ,required=true,schema=@Schema()) @RequestHeader(value="x-financial-member-id", required=true) String xFinancialMemberId,@Parameter(in = ParameterIn.HEADER, description = "API authorization key provided to your team." ,required=true,schema=@Schema()) @RequestHeader(value="x-api-key", required=true) String xApiKey,@Parameter(in = ParameterIn.HEADER, description = "Date on which the trade will be submitted for processing to the FMI.  Note that this parameter enables you to fast forward through the trade lifecycle for the purpose of the hackathon. The value must be specified in ISO date format(yyyy-MM-dd)." ,required=true,schema=@Schema()) @RequestHeader(value="x-simulation-date", required=true) String xSimulationDate,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody SettlementRequestBody body) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-participant-id", xParticipantId);
        headers.set("x-api-key", xApiKey);
        headers.set("x-api-request-id", String.valueOf(xApiRequestId));
        headers.set("x-financial-member-id", xFinancialMemberId);
        headers.set("x-simulation-date", xSimulationDate);

        HttpEntity<SettlementRequestBody> requestEntity =
                new HttpEntity<>(body, headers);
        return repoTradesService.postSettlementRequest(requestEntity);
    }

    public ResponseEntity<RepoTradeSubmissionResponse> tradeClearingRequest(@Parameter(in = ParameterIn.HEADER, description = "Unique request identifier for the request." ,required=true,schema=@Schema()) @RequestHeader(value="x-api-request-id", required=true) UUID xApiRequestId,@Parameter(in = ParameterIn.HEADER, description = "Unique team identifier provided to your team." ,required=true,schema=@Schema()) @RequestHeader(value="x-participant-id", required=true) String xParticipantId,@Parameter(in = ParameterIn.HEADER, description = "Name of the party submitting the trade (should match with the value specified in the input business event data). Possible values are CLIENT01,CLIENT02,CLIENT03 OR DEALER01,DEALER02." ,required=true,schema=@Schema()) @RequestHeader(value="x-financial-member-id", required=true) String xFinancialMemberId,@Parameter(in = ParameterIn.HEADER, description = "API authorization key provided to your team." ,required=true,schema=@Schema()) @RequestHeader(value="x-api-key", required=true) String xApiKey,@Parameter(in = ParameterIn.HEADER, description = "Date on which the trade will be submitted for processing to the FMI. Note that this parameter enables you to fast forward through the trade lifecycle for the purpose of the hackathon. The value must be specified in ISO date format(yyyy-MM-dd)." ,required=true,schema=@Schema()) @RequestHeader(value="x-simulation-date", required=true) String xSimulationDate,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ClearingRequestBody body) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-participant-id", xParticipantId);
        headers.set("x-api-key", xApiKey);
        headers.set("x-api-request-id", String.valueOf(xApiRequestId));
        headers.set("x-financial-member-id", xFinancialMemberId);
        headers.set("x-simulation-date", xSimulationDate);
        HttpEntity<ClearingRequestBody> requestEntity =
                new HttpEntity<>(body, headers);
        return repoTradesService.tradeClearing(requestEntity);
    }

    public ResponseEntity<List<Trade>> getAllTrades(){
        return ResponseEntity.ok()
                .body(repoTradesService.getTradesList());


    }

}
