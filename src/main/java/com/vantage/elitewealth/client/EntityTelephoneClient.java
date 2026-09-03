package com.vantage.elitewealth.client;

import com.vantage.elitewealth.model.request.TelephoneRequest;
import com.vantage.elitewealth.security.TokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
public class EntityTelephoneClient extends BaseEliteWealthClient {

    private final RestTemplate restTemplate;

    @Value("${elitewealth.base-url}")
    private String baseUrl;

    public EntityTelephoneClient(RestTemplate restTemplate, TokenService tokenService) {
        super(tokenService);
        this.restTemplate = restTemplate;
    }

    public List<Map<String, Object>> getTelephones(Long entityId) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/telephones";
        ResponseEntity<List> response = restTemplate.exchange(
                url, HttpMethod.GET, authorizedEntity(), List.class);
        return response.getBody();
    }

    public Map<String, Object> createTelephone(Long entityId, TelephoneRequest request) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/telephones";
        ResponseEntity<Map> response = restTemplate.exchange(
                url, HttpMethod.POST, authorizedEntity(request), Map.class);
        return response.getBody();
    }

    public Map<String, Object> getTelephone(Long entityId, Long telephoneId) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/telephones/" + telephoneId;
        ResponseEntity<Map> response = restTemplate.exchange(
                url, HttpMethod.GET, authorizedEntity(), Map.class);
        return response.getBody();
    }

    public void deleteTelephone(Long entityId, Long telephoneId) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/telephones/" + telephoneId;
        restTemplate.exchange(url, HttpMethod.DELETE, authorizedEntity(), Void.class);
    }
}
