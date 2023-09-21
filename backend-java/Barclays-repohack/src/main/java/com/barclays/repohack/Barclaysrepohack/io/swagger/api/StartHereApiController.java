package com.barclays.repohack.Barclaysrepohack.io.swagger.api;

import com.barclays.repohack.Barclaysrepohack.io.swagger.model.PingResponse;
import com.barclays.repohack.Barclaysrepohack.io.swagger.service.StartHereApiService;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class StartHereApiController implements StartHereApi {

    private static final Logger log = LoggerFactory.getLogger(StartHereApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final StartHereApiService startHereApiService;

    @org.springframework.beans.factory.annotation.Autowired
    public StartHereApiController(ObjectMapper objectMapper, HttpServletRequest request, StartHereApiService startHereApiService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.startHereApiService = startHereApiService;
    }

    public ResponseEntity<PingResponse> getAuthPing(@Parameter(in = ParameterIn.HEADER, description = "Unique team id assigned to your team." ,required=true,schema=@Schema()) @RequestHeader(value="x-participant-id", required=true) String xParticipantId,@Parameter(in = ParameterIn.HEADER, description = "API authorization key provided to your team." ,required=true,schema=@Schema()) @RequestHeader(value="x-api-key", required=true) String xApiKey) {
            HttpHeaders headers = new HttpHeaders();
            headers.set("x-participant-id", xParticipantId);
            headers.set("x-api-key", xApiKey);
            return startHereApiService.getAuthPingResponse(headers);
    }

    public ResponseEntity<PingResponse> getPublicPing() {
       return startHereApiService.getPublicPing();
    }

}
