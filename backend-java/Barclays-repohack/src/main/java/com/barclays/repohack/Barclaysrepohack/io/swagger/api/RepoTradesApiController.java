package com.barclays.repohack.Barclaysrepohack.io.swagger.api;

import com.barclays.repohack.Barclaysrepohack.io.swagger.model.AccessDeniedResponse;
import com.barclays.repohack.Barclaysrepohack.io.swagger.model.BadRequestResponse;
import com.barclays.repohack.Barclaysrepohack.io.swagger.model.ClearingRequestBody;
import com.barclays.repohack.Barclaysrepohack.io.swagger.model.ErrorResponseBody;
import com.barclays.repohack.Barclaysrepohack.io.swagger.model.NotFoundResponse;
import com.barclays.repohack.Barclaysrepohack.io.swagger.model.RepoTradeExecutionSubmissionRequest;
import com.barclays.repohack.Barclaysrepohack.io.swagger.model.RepoTradeSubmissionResponse;
import com.barclays.repohack.Barclaysrepohack.io.swagger.model.SettlementRequestBody;
import com.barclays.repohack.Barclaysrepohack.io.swagger.model.TradeBusinessEventsQueryRequest;
import com.barclays.repohack.Barclaysrepohack.io.swagger.model.TradeBusinessEventsQueryResponse;
import com.barclays.repohack.Barclaysrepohack.io.swagger.model.TradeWorkflowStatusResponse;
import java.util.UUID;

import com.barclays.repohack.Barclaysrepohack.io.swagger.service.RepoTradesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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

    public ResponseEntity<TradeBusinessEventsQueryResponse> getBusinessEvents(@Parameter(in = ParameterIn.HEADER, description = "Unique request identifier for the request." ,required=true,schema=@Schema()) @RequestHeader(value="x-api-request-id", required=true) UUID xApiRequestId,@Parameter(in = ParameterIn.HEADER, description = "Unique team identifier provided to your team." ,required=true,schema=@Schema()) @RequestHeader(value="x-participant-id", required=true) String xParticipantId,@Parameter(in = ParameterIn.HEADER, description = "Name of the party retrieving the trade(s) data. Possible values CLIENT01,CLIENT02,CLIENT03 OR DEALER01,DEALER02 OR CCP01 for cleared trades." ,required=true,schema=@Schema()) @RequestHeader(value="x-financial-member-id", required=true) String xFinancialMemberId,@Parameter(in = ParameterIn.HEADER, description = "API authorization key provided to your team." ,required=true,schema=@Schema()) @RequestHeader(value="x-api-key", required=true) String xApiKey,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody TradeBusinessEventsQueryRequest body,@Parameter(in = ParameterIn.HEADER, description = "Date on which the trade(s) was processed at the FMIs. The value should be specified in ISO date format(yyyy-MM-dd)." ,schema=@Schema()) @RequestHeader(value="x-simulation-date", required=false) String xSimulationDate) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<TradeBusinessEventsQueryResponse>(objectMapper.readValue("", TradeBusinessEventsQueryResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<TradeBusinessEventsQueryResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<TradeBusinessEventsQueryResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<TradeWorkflowStatusResponse> getWorkflowEvents(@Parameter(in = ParameterIn.HEADER, description = "Unique request identifier for the request." ,required=true,schema=@Schema()) @RequestHeader(value="x-api-request-id", required=true) UUID xApiRequestId,@Parameter(in = ParameterIn.HEADER, description = "Unique team identifier provided to your team." ,required=true,schema=@Schema()) @RequestHeader(value="x-participant-id", required=true) String xParticipantId,@Parameter(in = ParameterIn.HEADER, description = "Name of the party retrieving the workflow statuses for its trade(s) processed at the FMIs. Possible values are CLIENT01,CLIENT02,CLIENT03 OR DEALER01,DEALER02 OR CCP01 for cleared trades." ,required=true,schema=@Schema()) @RequestHeader(value="x-financial-member-id", required=true) String xFinancialMemberId,@Parameter(in = ParameterIn.HEADER, description = "API authorization key provided to your team." ,required=true,schema=@Schema()) @RequestHeader(value="x-api-key", required=true) String xApiKey,@Parameter(in = ParameterIn.QUERY, description = "Unique identifier for the trade." ,schema=@Schema()) @Valid @RequestParam(value = "tradeId", required = false) String tradeId,@Parameter(in = ParameterIn.QUERY, description = "Name of the financial market infrastructure for which you will like to pull the trades details. Possible values are: TRADE_MATCHING_SERVICE, TRADE_CLEARING_SERVICE, TRADE_SETTLEMENT_SERVICE" ,schema=@Schema()) @Valid @RequestParam(value = "fmi", required = false) String fmi) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<TradeWorkflowStatusResponse>(objectMapper.readValue("{\n  \"tradeMatchingService\" : [ {\n    \"workflowEvents\" : [ {\n      \"eventSequence\" : 1,\n      \"requestId\" : \"5e970526-6ebe-4d9f-bab5-9f05fa07dcfd\",\n      \"tradeStatus\" : \"TRADE_ACCEPTED\",\n      \"eventTimeStamp\" : \"2023-08-25T10:26:24.441Z\",\n      \"tradeMatchingStatus\" : \"TRADE_MATCH_SUCCESS\"\n    }, {\n      \"eventSequence\" : 1,\n      \"requestId\" : \"5e970526-6ebe-4d9f-bab5-9f05fa07dcfd\",\n      \"tradeStatus\" : \"TRADE_ACCEPTED\",\n      \"eventTimeStamp\" : \"2023-08-25T10:26:24.441Z\",\n      \"tradeMatchingStatus\" : \"TRADE_MATCH_SUCCESS\"\n    } ],\n    \"tradeId\" : \"UC2Q0EKXFH6260\"\n  }, {\n    \"workflowEvents\" : [ {\n      \"eventSequence\" : 1,\n      \"requestId\" : \"5e970526-6ebe-4d9f-bab5-9f05fa07dcfd\",\n      \"tradeStatus\" : \"TRADE_ACCEPTED\",\n      \"eventTimeStamp\" : \"2023-08-25T10:26:24.441Z\",\n      \"tradeMatchingStatus\" : \"TRADE_MATCH_SUCCESS\"\n    }, {\n      \"eventSequence\" : 1,\n      \"requestId\" : \"5e970526-6ebe-4d9f-bab5-9f05fa07dcfd\",\n      \"tradeStatus\" : \"TRADE_ACCEPTED\",\n      \"eventTimeStamp\" : \"2023-08-25T10:26:24.441Z\",\n      \"tradeMatchingStatus\" : \"TRADE_MATCH_SUCCESS\"\n    } ],\n    \"tradeId\" : \"UC2Q0EKXFH6260\"\n  } ],\n  \"tradeClearingService\" : [ null, null ],\n  \"tradeSettlementService\" : [ null, null ]\n}", TradeWorkflowStatusResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<TradeWorkflowStatusResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<TradeWorkflowStatusResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<RepoTradeSubmissionResponse> postExecutionRequest(@Parameter(in = ParameterIn.HEADER, description = "Unique request identifier for the request." ,required=true,schema=@Schema()) @RequestHeader(value="x-api-request-id", required=true) UUID xApiRequestId,@Parameter(in = ParameterIn.HEADER, description = "Unique team identifier provided to your team." ,required=true,schema=@Schema()) @RequestHeader(value="x-participant-id", required=true) String xParticipantId,@Parameter(in = ParameterIn.HEADER, description = "Name of the party submitting the trade (should match with the value specified in the input trade data). Possible values are CLIENT01,CLIENT02,CLIENT03 OR DEALER01,DEALER02." ,required=true,schema=@Schema()) @RequestHeader(value="x-financial-member-id", required=true) String xFinancialMemberId,@Parameter(in = ParameterIn.HEADER, description = "API authorization key provided to your team." ,required=true,schema=@Schema()) @RequestHeader(value="x-api-key", required=true) String xApiKey,@Parameter(in = ParameterIn.HEADER, description = "Date on which the trade will be submitted for processing to the FMI. Note that this parameter enables you to fast forward through the trade lifecycle for the purpose of the hackathon. The value must be specified in ISO date format(yyyy-MM-dd)." ,required=true,schema=@Schema()) @RequestHeader(value="x-simulation-date", required=true) String xSimulationDate,@Parameter(in = ParameterIn.DEFAULT, description = "Repo Trade Execution Request", required=true, schema=@Schema()) @Valid @RequestBody RepoTradeExecutionSubmissionRequest body) {
        String accept = request.getHeader("Accept");

        if (accept != null && accept.contains("application/json")) {
                HttpHeaders headers = new HttpHeaders();
                headers.set("x-participant-id", xParticipantId);
                headers.set("x-api-key", xApiKey);
                headers.set("x-api-request-id", String.valueOf(xApiRequestId));
                headers.set("x-financial-member-id", xFinancialMemberId);
                headers.set("x-simulation-date", xSimulationDate);
                HttpEntity<RepoTradeExecutionSubmissionRequest> requestEntity =
                        new HttpEntity<>(body, headers);

                return repoTradesService.createTradeExecutionRequest(requestEntity);
                //return new ResponseEntity<RepoTradeSubmissionResponse>(objectMapper.readValue("{\n  \"tradeStatus\" : \"TRADE_ACCEPTED\",\n  \"tradeId\" : \"UC2Q0EKXFH6260\"\n}", RepoTradeSubmissionResponse.class), HttpStatus.NOT_IMPLEMENTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<RepoTradeSubmissionResponse> postSettlementRequest(@Parameter(in = ParameterIn.HEADER, description = "Unique request identifier for the request." ,required=true,schema=@Schema()) @RequestHeader(value="x-api-request-id", required=true) UUID xApiRequestId,@Parameter(in = ParameterIn.HEADER, description = "Unique team identifier provided to your team." ,required=true,schema=@Schema()) @RequestHeader(value="x-participant-id", required=true) String xParticipantId,@Parameter(in = ParameterIn.HEADER, description = "Name of the party submitting the trade (should match with the value specified in the input business event). Possible values are CLIENT01,CLIENT02,CLIENT03 OR DEALER01,DEALER02 OR CCP01 for cleared trades." ,required=true,schema=@Schema()) @RequestHeader(value="x-financial-member-id", required=true) String xFinancialMemberId,@Parameter(in = ParameterIn.HEADER, description = "API authorization key provided to your team." ,required=true,schema=@Schema()) @RequestHeader(value="x-api-key", required=true) String xApiKey,@Parameter(in = ParameterIn.HEADER, description = "Date on which the trade will be submitted for processing to the FMI.  Note that this parameter enables you to fast forward through the trade lifecycle for the purpose of the hackathon. The value must be specified in ISO date format(yyyy-MM-dd)." ,required=true,schema=@Schema()) @RequestHeader(value="x-simulation-date", required=true) String xSimulationDate,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody SettlementRequestBody body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<RepoTradeSubmissionResponse>(objectMapper.readValue("{\n  \"tradeStatus\" : \"TRADE_ACCEPTED\",\n  \"tradeId\" : \"UC2Q0EKXFH6260\"\n}", RepoTradeSubmissionResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<RepoTradeSubmissionResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<RepoTradeSubmissionResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<RepoTradeSubmissionResponse> postSettlementRequest1(@Parameter(in = ParameterIn.HEADER, description = "Unique request identifier for the request." ,required=true,schema=@Schema()) @RequestHeader(value="x-api-request-id", required=true) UUID xApiRequestId,@Parameter(in = ParameterIn.HEADER, description = "Unique team identifier provided to your team." ,required=true,schema=@Schema()) @RequestHeader(value="x-participant-id", required=true) String xParticipantId,@Parameter(in = ParameterIn.HEADER, description = "Name of the party submitting the trade (should match with the value specified in the input business event data). Possible values are CLIENT01,CLIENT02,CLIENT03 OR DEALER01,DEALER02." ,required=true,schema=@Schema()) @RequestHeader(value="x-financial-member-id", required=true) String xFinancialMemberId,@Parameter(in = ParameterIn.HEADER, description = "API authorization key provided to your team." ,required=true,schema=@Schema()) @RequestHeader(value="x-api-key", required=true) String xApiKey,@Parameter(in = ParameterIn.HEADER, description = "Date on which the trade will be submitted for processing to the FMI. Note that this parameter enables you to fast forward through the trade lifecycle for the purpose of the hackathon. The value must be specified in ISO date format(yyyy-MM-dd)." ,required=true,schema=@Schema()) @RequestHeader(value="x-simulation-date", required=true) String xSimulationDate,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ClearingRequestBody body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<RepoTradeSubmissionResponse>(objectMapper.readValue("{\n  \"tradeStatus\" : \"TRADE_ACCEPTED\",\n  \"tradeId\" : \"UC2Q0EKXFH6260\"\n}", RepoTradeSubmissionResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<RepoTradeSubmissionResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<RepoTradeSubmissionResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
