package com.vantage.elitewealth.client;

import com.vantage.elitewealth.model.request.StaffRelationRequest;
import com.vantage.elitewealth.security.TokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
public class EntityStaffRelationClient extends BaseEliteWealthClient {

    private final RestTemplate restTemplate;

    @Value("${elitewealth.base-url}")
    private String baseUrl;

    public EntityStaffRelationClient(RestTemplate restTemplate, TokenService tokenService) {
        super(tokenService);
        this.restTemplate = restTemplate;
    }

    public List<Map<String, Object>> getClientStaffRelations(Long entityId) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/client-staff-relations";
        ResponseEntity<List> response = restTemplate.exchange(
                url, HttpMethod.GET, authorizedEntity(), List.class);
        return response.getBody();
    }

    public Map<String, Object> createClientStaffRelation(Long entityId, StaffRelationRequest request) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/client-staff-relations";
        ResponseEntity<Map> response = restTemplate.exchange(
                url, HttpMethod.POST, authorizedEntity(request), Map.class);
        return response.getBody();
    }

    public Map<String, Object> getClientStaffRelation(Long entityId) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/client-staff-relations/get";
        ResponseEntity<Map> response = restTemplate.exchange(
                url, HttpMethod.GET, authorizedEntity(), Map.class);
        return response.getBody();
    }

    public List<Map<String, Object>> getStaffMemberClients(Long entityId) {
        String url = baseUrl + "/restApiData/Entity/" + entityId + "/client-staff-relations/staff-member-clients";
        ResponseEntity<List> response = restTemplate.exchange(
                url, HttpMethod.GET, authorizedEntity(), List.class);
        return response.getBody();
    }
}
