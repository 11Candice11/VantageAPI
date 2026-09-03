package com.vantage.elitewealth.client;

import com.vantage.elitewealth.model.request.QualificationRequest;
import com.vantage.elitewealth.security.TokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
public class EntityQualificationClient extends BaseEliteWealthClient {

    private final RestTemplate restTemplate;

    @Value("${elitewealth.base-url}")
    private String baseUrl;

    public EntityQualificationClient(RestTemplate restTemplate, TokenService tokenService) {
        super(tokenService);
        this.restTemplate = restTemplate;
    }

    public List<Map<String, Object>> getQualifications(Long entityId) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/qualifications";
        ResponseEntity<List> response = restTemplate.exchange(
                url, HttpMethod.GET, authorizedEntity(), List.class);
        return response.getBody();
    }

    public Map<String, Object> createQualification(Long entityId, QualificationRequest request) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/qualifications";
        ResponseEntity<Map> response = restTemplate.exchange(
                url, HttpMethod.POST, authorizedEntity(request), Map.class);
        return response.getBody();
    }

    public Map<String, Object> getQualification(Long entityId, Long qualificationId) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/qualifications/" + qualificationId;
        ResponseEntity<Map> response = restTemplate.exchange(
                url, HttpMethod.GET, authorizedEntity(), Map.class);
        return response.getBody();
    }

    public void deleteQualification(Long entityId, Long qualificationId) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/qualifications/" + qualificationId;
        restTemplate.exchange(url, HttpMethod.DELETE, authorizedEntity(), Void.class);
    }
}
