package com.vantage.elitewealth.client;

import com.vantage.elitewealth.model.request.EmploymentRequest;
import com.vantage.elitewealth.security.TokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
public class EntityEmploymentClient extends BaseEliteWealthClient {

    private final RestTemplate restTemplate;

    @Value("${elitewealth.base-url}")
    private String baseUrl;

    public EntityEmploymentClient(RestTemplate restTemplate, TokenService tokenService) {
        super(tokenService);
        this.restTemplate = restTemplate;
    }

    public List<Map<String, Object>> getEmploymentHistory(Long entityId) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/employment-history";
        ResponseEntity<List> response = restTemplate.exchange(
                url, HttpMethod.GET, authorizedEntity(), List.class);
        return response.getBody();
    }

    public Map<String, Object> createEmployment(Long entityId, EmploymentRequest request) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/employment-history";
        ResponseEntity<Map> response = restTemplate.exchange(
                url, HttpMethod.POST, authorizedEntity(request), Map.class);
        return response.getBody();
    }

    public Map<String, Object> getEmployment(Long entityId, Long employmentId) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/employment-history/" + employmentId;
        ResponseEntity<Map> response = restTemplate.exchange(
                url, HttpMethod.GET, authorizedEntity(), Map.class);
        return response.getBody();
    }

    public void deleteEmployment(Long entityId, Long employmentId) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/employment-history/" + employmentId;
        restTemplate.exchange(url, HttpMethod.DELETE, authorizedEntity(), Void.class);
    }
}
