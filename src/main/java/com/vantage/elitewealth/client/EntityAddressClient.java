package com.vantage.elitewealth.client;

import com.vantage.elitewealth.model.request.AddressRequest;
import com.vantage.elitewealth.security.TokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
public class EntityAddressClient extends BaseEliteWealthClient {

    private final RestTemplate restTemplate;

    @Value("${elitewealth.base-url}")
    private String baseUrl;

    public EntityAddressClient(RestTemplate restTemplate, TokenService tokenService) {
        super(tokenService);
        this.restTemplate = restTemplate;
    }

    public List<Map<String, Object>> getAddresses(Long addressEntityId) {
        String url = baseUrl + "/restApiData/Entity/" + addressEntityId + "/addresses";
        ResponseEntity<List> response = restTemplate.exchange(
                url, HttpMethod.GET, authorizedEntity(), List.class);
        return response.getBody();
    }

    public Map<String, Object> createAddress(Long addressEntityId, AddressRequest request) {
        String url = baseUrl + "/restApiData/Entity/" + addressEntityId + "/addresses";
        ResponseEntity<Map> response = restTemplate.exchange(
                url, HttpMethod.POST, authorizedEntity(request), Map.class);
        return response.getBody();
    }

    public Map<String, Object> getAddress(Long entityId, Long addressId) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/addresses/" + addressId;
        ResponseEntity<Map> response = restTemplate.exchange(
                url, HttpMethod.GET, authorizedEntity(), Map.class);
        return response.getBody();
    }

    public void deleteAddress(Long entityId, Long addressId) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/addresses/" + addressId;
        restTemplate.exchange(url, HttpMethod.DELETE, authorizedEntity(), Void.class);
    }
}
