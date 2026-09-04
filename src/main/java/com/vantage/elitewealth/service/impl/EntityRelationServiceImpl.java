package com.vantage.elitewealth.service.impl;

import com.vantage.elitewealth.client.EntityRelationClient;
import com.vantage.elitewealth.model.request.EntityRelationRequest;
import com.vantage.elitewealth.service.EntityRelationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EntityRelationServiceImpl implements EntityRelationService {

    private final EntityRelationClient entityRelationClient;

    public EntityRelationServiceImpl(EntityRelationClient entityRelationClient) {
        this.entityRelationClient = entityRelationClient;
    }

    @Override
    public List<Map<String, Object>> getRelations(Long entityId) {
        return entityRelationClient.getRelations(entityId);
    }

    @Override
    public Map<String, Object> createRelation(Long entityId, EntityRelationRequest request) {
        return entityRelationClient.createRelation(entityId, request);
    }

    @Override
    public List<Map<String, Object>> getInverseRelations(Long entityId) {
        return entityRelationClient.getInverseRelations(entityId);
    }

    @Override
    public Map<String, Object> getRelation(Long entityId) {
        return entityRelationClient.getRelation(entityId);
    }
}
