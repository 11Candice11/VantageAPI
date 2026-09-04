package com.vantage.elitewealth.service.impl;

import com.vantage.elitewealth.client.EntityStaffRelationClient;
import com.vantage.elitewealth.model.request.StaffRelationRequest;
import com.vantage.elitewealth.service.EntityStaffRelationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EntityStaffRelationServiceImpl implements EntityStaffRelationService {

    private final EntityStaffRelationClient entityStaffRelationClient;

    public EntityStaffRelationServiceImpl(EntityStaffRelationClient entityStaffRelationClient) {
        this.entityStaffRelationClient = entityStaffRelationClient;
    }

    @Override
    public List<Map<String, Object>> getClientStaffRelations(Long entityId) {
        return entityStaffRelationClient.getClientStaffRelations(entityId);
    }

    @Override
    public Map<String, Object> createClientStaffRelation(Long entityId, StaffRelationRequest request) {
        return entityStaffRelationClient.createClientStaffRelation(entityId, request);
    }

    @Override
    public Map<String, Object> getClientStaffRelation(Long entityId) {
        return entityStaffRelationClient.getClientStaffRelation(entityId);
    }

    @Override
    public List<Map<String, Object>> getStaffMemberClients(Long entityId) {
        return entityStaffRelationClient.getStaffMemberClients(entityId);
    }
}
