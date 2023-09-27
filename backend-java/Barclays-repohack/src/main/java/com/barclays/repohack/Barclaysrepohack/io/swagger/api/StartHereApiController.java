package com.barclays.repohack.Barclaysrepohack.io.swagger.api;

import com.barclays.repohack.Barclaysrepohack.io.swagger.model.PingResponse;
import com.barclays.repohack.Barclaysrepohack.io.swagger.service.StartHereApiService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
