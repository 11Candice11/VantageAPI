package com.vantage.elitewealth.service.impl;

import com.vantage.elitewealth.client.EntityQualificationClient;
import com.vantage.elitewealth.model.request.QualificationRequest;
import com.vantage.elitewealth.service.EntityQualificationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EntityQualificationServiceImpl implements EntityQualificationService {

    private final EntityQualificationClient entityQualificationClient;

    public EntityQualificationServiceImpl(EntityQualificationClient entityQualificationClient) {
        this.entityQualificationClient = entityQualificationClient;
    }

    @Override
    public List<Map<String, Object>> getQualifications(Long entityId) {
        return entityQualificationClient.getQualifications(entityId);
    }

    @Override
    public Map<String, Object> createQualification(Long entityId, QualificationRequest request) {
        return entityQualificationClient.createQualification(entityId, request);
    }

    @Override
    public Map<String, Object> getQualification(Long entityId, Long qualificationId) {
        return entityQualificationClient.getQualification(entityId, qualificationId);
    }

    @Override
    public void deleteQualification(Long entityId, Long qualificationId) {
        entityQualificationClient.deleteQualification(entityId, qualificationId);
    }
}
