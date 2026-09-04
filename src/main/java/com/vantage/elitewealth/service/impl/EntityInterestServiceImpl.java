package com.vantage.elitewealth.service.impl;

import com.vantage.elitewealth.client.EntityInterestClient;
import com.vantage.elitewealth.model.request.InterestRequest;
import com.vantage.elitewealth.service.EntityInterestService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EntityInterestServiceImpl implements EntityInterestService {

    private final EntityInterestClient entityInterestClient;

    public EntityInterestServiceImpl(EntityInterestClient entityInterestClient) {
        this.entityInterestClient = entityInterestClient;
    }

    @Override
    public List<Map<String, Object>> getInterests(Long entityId) {
        return entityInterestClient.getInterests(entityId);
    }

    @Override
    public Map<String, Object> createInterest(Long entityId, InterestRequest request) {
        return entityInterestClient.createInterest(entityId, request);
    }

    @Override
    public Map<String, Object> getInterest(Long entityId, Long interestId) {
        return entityInterestClient.getInterest(entityId, interestId);
    }

    @Override
    public void deleteInterest(Long entityId, Long interestId) {
        entityInterestClient.deleteInterest(entityId, interestId);
    }
}
