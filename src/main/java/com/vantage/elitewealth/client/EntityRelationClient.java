package com.vantage.elitewealth.client;

import com.vantage.elitewealth.model.request.EntityRelationRequest;
import com.vantage.elitewealth.security.TokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
public class EntityRelationClient extends BaseEliteWealthClient {

    private final RestTemplate restTemplate;

    @Value("${elitewealth.base-url}")
    private String baseUrl;

    public EntityRelationClient(RestTemplate restTemplate, TokenService tokenService) {
        super(tokenService);
        this.restTemplate = restTemplate;
    }

    public List<Map<String, Object>> getRelations(Long entityId) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/relations";
        ResponseEntity<List> response = restTemplate.exchange(
                url, HttpMethod.GET, authorizedEntity(), List.class);
        return response.getBody();
    }

    public Map<String, Object> createRelation(Long entityId, EntityRelationRequest request) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/relations";
        ResponseEntity<Map> response = restTemplate.exchange(
                url, HttpMethod.POST, authorizedEntity(request), Map.class);
        return response.getBody();
    }

    public List<Map<String, Object>> getInverseRelations(Long entityId) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/relations/inverse";
        ResponseEntity<List> response = restTemplate.exchange(
                url, HttpMethod.GET, authorizedEntity(), List.class);
        return response.getBody();
    }

    public Map<String, Object> getRelation(Long entityId) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/relations/get";
        ResponseEntity<Map> response = restTemplate.exchange(
                url, HttpMethod.GET, authorizedEntity(), Map.class);
        return response.getBody();
    }
}
