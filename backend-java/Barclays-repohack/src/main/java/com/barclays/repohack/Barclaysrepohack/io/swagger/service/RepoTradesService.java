package com.barclays.repohack.Barclaysrepohack.io.swagger.service;

import com.barclays.repohack.Barclaysrepohack.io.swagger.model.PingResponse;
import com.barclays.repohack.Barclaysrepohack.io.swagger.model.RepoTradeExecutionSubmissionRequest;
import com.barclays.repohack.Barclaysrepohack.io.swagger.model.RepoTradeSubmissionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Service
public class RepoTradesService {

    private final RestTemplate restTemplate;

    @Autowired
    public RepoTradesService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<RepoTradeSubmissionResponse>  createTradeExecutionRequest(HttpEntity<RepoTradeExecutionSubmissionRequest> requestEntity){
           return restTemplate.exchange(
                   "https://repohack2023.nayaone.com/repoTrades/execution", HttpMethod.POST, requestEntity, RepoTradeSubmissionResponse.class);
    }
}
