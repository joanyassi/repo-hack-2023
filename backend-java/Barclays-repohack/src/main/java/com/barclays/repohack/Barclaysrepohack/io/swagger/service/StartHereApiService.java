package com.barclays.repohack.Barclaysrepohack.io.swagger.service;

import com.barclays.repohack.Barclaysrepohack.io.swagger.model.PingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StartHereApiService {

    private final RestTemplate restTemplate;

    @Autowired
    public StartHereApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<PingResponse> getPingResponse(HttpHeaders headers){
        return restTemplate.exchange(
                "https://repohack2023.nayaone.com/start-here/public-ping", HttpMethod.GET, new HttpEntity<>(headers),
                PingResponse.class);
    }

    public ResponseEntity<PingResponse> getPublicPing(){
        return restTemplate.getForEntity(
                "https://repohack2023.nayaone.com/start-here/public-ping", PingResponse.class);
    }
}
