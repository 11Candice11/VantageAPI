package com.vantage.elitewealth.client;

import com.vantage.elitewealth.model.request.EmailRequest;
import com.vantage.elitewealth.security.TokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
public class EntityEmailClient extends BaseEliteWealthClient {

    private final RestTemplate restTemplate;

    @Value("${elitewealth.base-url}")
    private String baseUrl;

    public EntityEmailClient(RestTemplate restTemplate, TokenService tokenService) {
        super(tokenService);
        this.restTemplate = restTemplate;
    }

    public List<Map<String, Object>> getEmails(Long entityId) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/emails";
        ResponseEntity<List> response = restTemplate.exchange(
                url, HttpMethod.GET, authorizedEntity(), List.class);
        return response.getBody();
    }

    public Map<String, Object> createEmail(Long entityId, EmailRequest request) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/emails";
        ResponseEntity<Map> response = restTemplate.exchange(
                url, HttpMethod.POST, authorizedEntity(request), Map.class);
        return response.getBody();
    }

    public Map<String, Object> getEmail(Long entityId, Long eMailId) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/emails/" + eMailId;
        ResponseEntity<Map> response = restTemplate.exchange(
                url, HttpMethod.GET, authorizedEntity(), Map.class);
        return response.getBody();
    }

    public void deleteEmail(Long entityId, Long eMailId) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/emails/" + eMailId;
        restTemplate.exchange(url, HttpMethod.DELETE, authorizedEntity(), Void.class);
    }
}
