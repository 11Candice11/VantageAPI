package com.vantage.elitewealth.client;

import com.vantage.elitewealth.security.TokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
public class EntityDocumentClient extends BaseEliteWealthClient {

    private final RestTemplate restTemplate;

    @Value("${elitewealth.base-url}")
    private String baseUrl;

    public EntityDocumentClient(RestTemplate restTemplate, TokenService tokenService) {
        super(tokenService);
        this.restTemplate = restTemplate;
    }

    public List<Map<String, Object>> getDocuments(Long entityId) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/documents";
        ResponseEntity<List> response = restTemplate.exchange(
                url, HttpMethod.GET, authorizedEntity(), List.class);
        return response.getBody();
    }

    public Map<String, Object> getDocument(Long entityId, Long documentId) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/documents/" + documentId;
        ResponseEntity<Map> response = restTemplate.exchange(
                url, HttpMethod.GET, authorizedEntity(), Map.class);
        return response.getBody();
    }
}
