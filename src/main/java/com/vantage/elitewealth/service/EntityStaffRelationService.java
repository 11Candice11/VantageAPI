package com.vantage.elitewealth.service;

import com.vantage.elitewealth.model.request.StaffRelationRequest;

import java.util.List;
import java.util.Map;

public interface EntityStaffRelationService {
    List<Map<String, Object>> getClientStaffRelations(Long entityId);
    Map<String, Object> createClientStaffRelation(Long entityId, StaffRelationRequest request);
    Map<String, Object> getClientStaffRelation(Long entityId);
    List<Map<String, Object>> getStaffMemberClients(Long entityId);
}
