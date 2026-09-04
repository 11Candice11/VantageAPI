package com.vantage.elitewealth.service.impl;

import com.vantage.elitewealth.client.EntityEmploymentClient;
import com.vantage.elitewealth.model.request.EmploymentRequest;
import com.vantage.elitewealth.service.EntityEmploymentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EntityEmploymentServiceImpl implements EntityEmploymentService {

    private final EntityEmploymentClient entityEmploymentClient;

    public EntityEmploymentServiceImpl(EntityEmploymentClient entityEmploymentClient) {
        this.entityEmploymentClient = entityEmploymentClient;
    }

    @Override
    public List<Map<String, Object>> getEmploymentHistory(Long entityId) {
        return entityEmploymentClient.getEmploymentHistory(entityId);
    }

    @Override
    public Map<String, Object> createEmployment(Long entityId, EmploymentRequest request) {
        return entityEmploymentClient.createEmployment(entityId, request);
    }

    @Override
    public Map<String, Object> getEmployment(Long entityId, Long employmentId) {
        return entityEmploymentClient.getEmployment(entityId, employmentId);
    }

    @Override
    public void deleteEmployment(Long entityId, Long employmentId) {
        entityEmploymentClient.deleteEmployment(entityId, employmentId);
    }
}
