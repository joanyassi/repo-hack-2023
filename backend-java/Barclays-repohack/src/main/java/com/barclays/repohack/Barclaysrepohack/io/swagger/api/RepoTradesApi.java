/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.46).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;


@Validated
public interface RepoTradesApi {

    @Operation(summary = "Get trade business events.", description = "Get the trade business events processed at the FMIs.", tags={ "Trade Query API" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successfully retrieved trade business events", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TradeBusinessEventsQueryResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad/Invalid request.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BadRequestResponse.class))),
        
        @ApiResponse(responseCode = "403", description = "Access Denied to API.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AccessDeniedResponse.class))),
        
        @ApiResponse(responseCode = "404", description = "Resource not found.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = NotFoundResponse.class))),
        
        @ApiResponse(responseCode = "500", description = "Internal Server Error.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseBody.class))) })
    @RequestMapping(value = "/repoTrades/tradeBusinessEventsQuery/",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<TradeBusinessEventsQueryResponse> getBusinessEvents(@Parameter(in = ParameterIn.HEADER, description = "Unique request identifier for the request." ,required=true,schema=@Schema()) @RequestHeader(value="x-api-request-id", required=true) UUID xApiRequestId, @Parameter(in = ParameterIn.HEADER, description = "Unique team identifier provided to your team." ,required=true,schema=@Schema()) @RequestHeader(value="x-participant-id", required=true) String xParticipantId, @Parameter(in = ParameterIn.HEADER, description = "Name of the party retrieving the trade(s) data. Possible values CLIENT01,CLIENT02,CLIENT03 OR DEALER01,DEALER02 OR CCP01 for cleared trades." ,required=true,schema=@Schema()) @RequestHeader(value="x-financial-member-id", required=true) String xFinancialMemberId, @Parameter(in = ParameterIn.HEADER, description = "API authorization key provided to your team." ,required=true,schema=@Schema()) @RequestHeader(value="x-api-key", required=true) String xApiKey, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody TradeBusinessEventsQueryRequest body, @Parameter(in = ParameterIn.HEADER, description = "Date on which the trade(s) was processed at the FMIs. The value should be specified in ISO date format(yyyy-MM-dd)." ,schema=@Schema()) @RequestHeader(value="x-simulation-date", required=false) String xSimulationDate);


    @Operation(summary = "Get trade workflow statuses.", description = "Get workflow statuses of the trades processed at the FMIs.", tags={ "Trade Query API" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successfully retrieved trade workflow statuses", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TradeWorkflowStatusResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad/Invalid request.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BadRequestResponse.class))),
        
        @ApiResponse(responseCode = "403", description = "Access Denied to API.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AccessDeniedResponse.class))),
        
        @ApiResponse(responseCode = "404", description = "Resource not found.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = NotFoundResponse.class))),
        
        @ApiResponse(responseCode = "500", description = "Internal Server Error.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseBody.class))) })
    @RequestMapping(value = "/repoTrades/tradeWorkflowStatus/",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<TradeWorkflowStatusResponse> getWorkflowEvents(@Parameter(in = ParameterIn.HEADER, description = "Unique request identifier for the request." ,required=true,schema=@Schema()) @RequestHeader(value="x-api-request-id", required=true) UUID xApiRequestId, @Parameter(in = ParameterIn.HEADER, description = "Unique team identifier provided to your team." ,required=true,schema=@Schema()) @RequestHeader(value="x-participant-id", required=true) String xParticipantId, @Parameter(in = ParameterIn.HEADER, description = "Name of the party retrieving the workflow statuses for its trade(s) processed at the FMIs. Possible values are CLIENT01,CLIENT02,CLIENT03 OR DEALER01,DEALER02 OR CCP01 for cleared trades." ,required=true,schema=@Schema()) @RequestHeader(value="x-financial-member-id", required=true) String xFinancialMemberId, @Parameter(in = ParameterIn.HEADER, description = "API authorization key provided to your team." ,required=true,schema=@Schema()) @RequestHeader(value="x-api-key", required=true) String xApiKey, @Parameter(in = ParameterIn.QUERY, description = "Unique identifier for the trade." ,schema=@Schema()) @Valid @RequestParam(value = "tradeId", required = false) String tradeId, @Parameter(in = ParameterIn.QUERY, description = "Name of the financial market infrastructure for which you will like to pull the trades details. Possible values are: TRADE_MATCHING_SERVICE, TRADE_CLEARING_SERVICE, TRADE_SETTLEMENT_SERVICE" ,schema=@Schema()) @Valid @RequestParam(value = "fmi", required = false) String fmi);


    @Operation(summary = "Submit trade execution request.", description = "Submit the trade request to the matching service of the trade matching middleware. ", tags={ "Trade Execution API" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RepoTradeSubmissionResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad/Invalid request.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BadRequestResponse.class))),
        
        @ApiResponse(responseCode = "403", description = "Access Denied to API.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AccessDeniedResponse.class))),
        
        @ApiResponse(responseCode = "500", description = "Internal Server Error.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseBody.class))) })
    @RequestMapping(value = "/repoTrades/execution",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<RepoTradeSubmissionResponse> postExecutionRequest(@Parameter(in = ParameterIn.HEADER, description = "Unique request identifier for the request." ,required=true,schema=@Schema()) @RequestHeader(value="x-api-request-id", required=true) UUID xApiRequestId, @Parameter(in = ParameterIn.HEADER, description = "Unique team identifier provided to your team." ,required=true,schema=@Schema()) @RequestHeader(value="x-participant-id", required=true) String xParticipantId, @Parameter(in = ParameterIn.HEADER, description = "Name of the party submitting the trade (should match with the value specified in the input trade data). Possible values are CLIENT01,CLIENT02,CLIENT03 OR DEALER01,DEALER02." ,required=true,schema=@Schema()) @RequestHeader(value="x-financial-member-id", required=true) String xFinancialMemberId, @Parameter(in = ParameterIn.HEADER, description = "API authorization key provided to your team." ,required=true,schema=@Schema()) @RequestHeader(value="x-api-key", required=true) String xApiKey, @Parameter(in = ParameterIn.HEADER, description = "Date on which the trade will be submitted for processing to the FMI. Note that this parameter enables you to fast forward through the trade lifecycle for the purpose of the hackathon. The value must be specified in ISO date format(yyyy-MM-dd)." ,required=true,schema=@Schema()) @RequestHeader(value="x-simulation-date", required=true) String xSimulationDate, @Parameter(in = ParameterIn.DEFAULT, description = "Repo Trade Execution Request", required=true, schema=@Schema()) @Valid @RequestBody RepoTradeExecutionSubmissionRequest body);


    @Operation(summary = "Submit trade settlement request.", description = "Submit the trade request to the CSD's settlement service. <br><br> Input to this API is a contract formation business event in CDM format. For UC1, it is the business event returned by the trade matching middleware service. For UC2 it is the business events returned by the clearing service. <br><br> You can use the Rosetta Technology Portal to understand the specification of a business event.", tags={ "Trade Settlement API" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RepoTradeSubmissionResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad/Invalid request.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BadRequestResponse.class))),
        
        @ApiResponse(responseCode = "403", description = "Access Denied to API.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AccessDeniedResponse.class))),
        
        @ApiResponse(responseCode = "500", description = "Internal Server Error.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseBody.class))) })
    @RequestMapping(value = "/repoTrades/settlement",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<RepoTradeSubmissionResponse> postSettlementRequest(@Parameter(in = ParameterIn.HEADER, description = "Unique request identifier for the request." ,required=true,schema=@Schema()) @RequestHeader(value="x-api-request-id", required=true) UUID xApiRequestId, @Parameter(in = ParameterIn.HEADER, description = "Unique team identifier provided to your team." ,required=true,schema=@Schema()) @RequestHeader(value="x-participant-id", required=true) String xParticipantId, @Parameter(in = ParameterIn.HEADER, description = "Name of the party submitting the trade (should match with the value specified in the input business event). Possible values are CLIENT01,CLIENT02,CLIENT03 OR DEALER01,DEALER02 OR CCP01 for cleared trades." ,required=true,schema=@Schema()) @RequestHeader(value="x-financial-member-id", required=true) String xFinancialMemberId, @Parameter(in = ParameterIn.HEADER, description = "API authorization key provided to your team." ,required=true,schema=@Schema()) @RequestHeader(value="x-api-key", required=true) String xApiKey, @Parameter(in = ParameterIn.HEADER, description = "Date on which the trade will be submitted for processing to the FMI.  Note that this parameter enables you to fast forward through the trade lifecycle for the purpose of the hackathon. The value must be specified in ISO date format(yyyy-MM-dd)." ,required=true,schema=@Schema()) @RequestHeader(value="x-simulation-date", required=true) String xSimulationDate, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody SettlementRequestBody body);


    @Operation(summary = "Submit trade clearing request.", description = "Submit the trade request to CCP's clearing service. <br><br> Input to this API is a contract formation business event (in CDM format) received from the trade matching service. <br><br> You can use the Rosetta Technology Portal to understand the specification of a business event", tags={ "Trade Clearing API" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RepoTradeSubmissionResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad/Invalid request.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BadRequestResponse.class))),
        
        @ApiResponse(responseCode = "403", description = "Access Denied to API.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AccessDeniedResponse.class))),
        
        @ApiResponse(responseCode = "500", description = "Internal Server Error.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseBody.class))) })
    @RequestMapping(value = "/repoTrades/clearing",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<RepoTradeSubmissionResponse> postSettlementRequest1(@Parameter(in = ParameterIn.HEADER, description = "Unique request identifier for the request." ,required=true,schema=@Schema()) @RequestHeader(value="x-api-request-id", required=true) UUID xApiRequestId, @Parameter(in = ParameterIn.HEADER, description = "Unique team identifier provided to your team." ,required=true,schema=@Schema()) @RequestHeader(value="x-participant-id", required=true) String xParticipantId, @Parameter(in = ParameterIn.HEADER, description = "Name of the party submitting the trade (should match with the value specified in the input business event data). Possible values are CLIENT01,CLIENT02,CLIENT03 OR DEALER01,DEALER02." ,required=true,schema=@Schema()) @RequestHeader(value="x-financial-member-id", required=true) String xFinancialMemberId, @Parameter(in = ParameterIn.HEADER, description = "API authorization key provided to your team." ,required=true,schema=@Schema()) @RequestHeader(value="x-api-key", required=true) String xApiKey, @Parameter(in = ParameterIn.HEADER, description = "Date on which the trade will be submitted for processing to the FMI. Note that this parameter enables you to fast forward through the trade lifecycle for the purpose of the hackathon. The value must be specified in ISO date format(yyyy-MM-dd)." ,required=true,schema=@Schema()) @RequestHeader(value="x-simulation-date", required=true) String xSimulationDate, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ClearingRequestBody body);

}
