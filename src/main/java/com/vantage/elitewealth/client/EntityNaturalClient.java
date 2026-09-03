package com.vantage.elitewealth.client;

import com.vantage.elitewealth.model.request.NaturalEntityRequest;
import com.vantage.elitewealth.security.TokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class EntityNaturalClient extends BaseEliteWealthClient {

    private final RestTemplate restTemplate;

    @Value("${elitewealth.base-url}")
    private String baseUrl;

    public EntityNaturalClient(RestTemplate restTemplate, TokenService tokenService) {
        super(tokenService);
        this.restTemplate = restTemplate;
    }

    public Map<String, Object> getNaturalEntityDetails(Long entityId) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/natural-entity-details";
        ResponseEntity<Map> response = restTemplate.exchange(
                url, HttpMethod.GET, authorizedEntity(), Map.class);
        return response.getBody();
    }

    public Map<String, Object> saveNaturalEntityDetails(NaturalEntityRequest request) {
        String url = baseUrl + "/restApiData/Entity/save-natural-entity-details";
        ResponseEntity<Map> response = restTemplate.exchange(
                url, HttpMethod.POST, authorizedEntity(request), Map.class);
        return response.getBody();
    }

    public Map<String, Object> createNaturalEntityClient(NaturalEntityRequest request) {
        String url = baseUrl + "/restApiData/Entity/create-natural-entity-client";
        ResponseEntity<Map> response = restTemplate.exchange(
                url, HttpMethod.POST, authorizedEntity(request), Map.class);
        return response.getBody();
    }
}
