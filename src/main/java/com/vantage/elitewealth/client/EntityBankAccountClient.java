package com.vantage.elitewealth.client;

import com.vantage.elitewealth.model.request.BankAccountRequest;
import com.vantage.elitewealth.security.TokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
public class EntityBankAccountClient extends BaseEliteWealthClient {

    private final RestTemplate restTemplate;

    @Value("${elitewealth.base-url}")
    private String baseUrl;

    public EntityBankAccountClient(RestTemplate restTemplate, TokenService tokenService) {
        super(tokenService);
        this.restTemplate = restTemplate;
    }

    public List<Map<String, Object>> getBankAccounts(Long entityId) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/bank-accounts";
        ResponseEntity<List> response = restTemplate.exchange(
                url, HttpMethod.GET, authorizedEntity(), List.class);
        return response.getBody();
    }

    public Map<String, Object> createBankAccount(Long entityId, BankAccountRequest request) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/bank-accounts";
        ResponseEntity<Map> response = restTemplate.exchange(
                url, HttpMethod.POST, authorizedEntity(request), Map.class);
        return response.getBody();
    }

    public Map<String, Object> getBankAccount(Long entityId, Long bankAccountId) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/bank-accounts/" + bankAccountId;
        ResponseEntity<Map> response = restTemplate.exchange(
                url, HttpMethod.GET, authorizedEntity(), Map.class);
        return response.getBody();
    }

    public void deleteBankAccount(Long entityId, Long bankAccountId) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/bank-accounts/" + bankAccountId;
        restTemplate.exchange(url, HttpMethod.DELETE, authorizedEntity(), Void.class);
    }
}
