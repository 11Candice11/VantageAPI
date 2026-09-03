package com.vantage.elitewealth.client;

import com.vantage.elitewealth.security.TokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class EntityReviewClient extends BaseEliteWealthClient {

    private final RestTemplate restTemplate;

    @Value("${elitewealth.base-url}")
    private String baseUrl;

    public EntityReviewClient(RestTemplate restTemplate, TokenService tokenService) {
        super(tokenService);
        this.restTemplate = restTemplate;
    }

    public List<Object> getReviews(Long entityId) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/reviews";
        ResponseEntity<List> response = restTemplate.exchange(
                url, HttpMethod.GET, authorizedEntity(), List.class);
        return response.getBody();
    }
}
