package com.vantage.elitewealth.client;

import com.vantage.elitewealth.model.request.LegalEntityRequest;
import com.vantage.elitewealth.security.TokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class EntityLegalClient extends BaseEliteWealthClient {

    private final RestTemplate restTemplate;

    @Value("${elitewealth.base-url}")
    private String baseUrl;

    public EntityLegalClient(RestTemplate restTemplate, TokenService tokenService) {
        super(tokenService);
        this.restTemplate = restTemplate;
    }

    public Map<String, Object> getLegalEntityDetails(Long legalEntityId) {
        String url = baseUrl + "/restApiData/Entity/" + legalEntityId + "/legal-entity-details";
        ResponseEntity<Map> response = restTemplate.exchange(
                url, HttpMethod.GET, authorizedEntity(), Map.class);
        return response.getBody();
    }

    public Map<String, Object> saveLegalEntityDetails(LegalEntityRequest request) {
        String url = baseUrl + "/restApiData/Entity/save-legal-entity-details";
        ResponseEntity<Map> response = restTemplate.exchange(
                url, HttpMethod.POST, authorizedEntity(request), Map.class);
        return response.getBody();
    }

    public Map<String, Object> createLegalEntityClient(LegalEntityRequest request) {
        String url = baseUrl + "/restApiData/Entity/create-legal-entity-client";
        ResponseEntity<Map> response = restTemplate.exchange(
                url, HttpMethod.POST, authorizedEntity(request), Map.class);
        return response.getBody();
    }
}
