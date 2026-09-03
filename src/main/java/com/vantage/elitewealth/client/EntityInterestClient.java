package com.vantage.elitewealth.client;

import com.vantage.elitewealth.model.request.InterestRequest;
import com.vantage.elitewealth.security.TokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
public class EntityInterestClient extends BaseEliteWealthClient {

    private final RestTemplate restTemplate;

    @Value("${elitewealth.base-url}")
    private String baseUrl;

    public EntityInterestClient(RestTemplate restTemplate, TokenService tokenService) {
        super(tokenService);
        this.restTemplate = restTemplate;
    }

    public List<Map<String, Object>> getInterests(Long entityId) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/interests";
        ResponseEntity<List> response = restTemplate.exchange(
                url, HttpMethod.GET, authorizedEntity(), List.class);
        return response.getBody();
    }

    public Map<String, Object> createInterest(Long entityId, InterestRequest request) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/interests";
        ResponseEntity<Map> response = restTemplate.exchange(
                url, HttpMethod.POST, authorizedEntity(request), Map.class);
        return response.getBody();
    }

    public Map<String, Object> getInterest(Long entityId, Long interestId) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/interests/" + interestId;
        ResponseEntity<Map> response = restTemplate.exchange(
                url, HttpMethod.GET, authorizedEntity(), Map.class);
        return response.getBody();
    }

    public void deleteInterest(Long entityId, Long interestId) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/interests/" + interestId;
        restTemplate.exchange(url, HttpMethod.DELETE, authorizedEntity(), Void.class);
    }
}
