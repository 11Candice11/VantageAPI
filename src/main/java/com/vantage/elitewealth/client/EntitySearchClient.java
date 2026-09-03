package com.vantage.elitewealth.client;

import com.vantage.elitewealth.security.TokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

@Component
public class EntitySearchClient extends BaseEliteWealthClient {

    private final RestTemplate restTemplate;

    @Value("${elitewealth.base-url}")
    private String baseUrl;

    public EntitySearchClient(RestTemplate restTemplate, TokenService tokenService) {
        super(tokenService);
        this.restTemplate = restTemplate;
    }

    public List<Map<String, Object>> searchEntity(String searchString) {
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl + "/restApiData/Entity/search-entity")
                .queryParam("searchString", searchString)
                .toUriString();
        ResponseEntity<List> response = restTemplate.exchange(url, HttpMethod.GET, authorizedEntity(), List.class);
        return response.getBody();
    }

    public List<Map<String, Object>> searchStaff(String searchString) {
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl + "/restApiData/Entity/search-staff")
                .queryParam("searchString", searchString)
                .toUriString();
        ResponseEntity<List> response = restTemplate.exchange(url, HttpMethod.GET, authorizedEntity(), List.class);
        return response.getBody();
    }

    public List<Map<String, Object>> searchRestrictedEntity() {
        String url = baseUrl + "/restApiData/Entity/search-restricted-entity";
        ResponseEntity<List> response = restTemplate.exchange(url, HttpMethod.GET, authorizedEntity(), List.class);
        return response.getBody();
    }

    public List<Map<String, Object>> searchRestrictedEntityByIdOrPassportOrRegistrationNumber() {
        String url = baseUrl + "/restApiData/Entity/search-restricted-entity-by-id-or-passport-or-registration-number";
        ResponseEntity<List> response = restTemplate.exchange(url, HttpMethod.GET, authorizedEntity(), List.class);
        return response.getBody();
    }

    public Map<String, Object> checkIfUserExists(String userName) {
        String url = baseUrl + "/restApiData/Entity/" + userName + "/check-if-user-exists";
        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, authorizedEntity(), Map.class);
        return response.getBody();
    }
}
