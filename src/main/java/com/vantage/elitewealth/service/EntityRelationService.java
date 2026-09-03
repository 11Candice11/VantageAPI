package com.vantage.elitewealth.service;

import com.vantage.elitewealth.model.request.EntityRelationRequest;

import java.util.List;
import java.util.Map;

public interface EntityRelationService {
    List<Map<String, Object>> getRelations(Long entityId);
    Map<String, Object> createRelation(Long entityId, EntityRelationRequest request);
    List<Map<String, Object>> getInverseRelations(Long entityId);
    Map<String, Object> getRelation(Long entityId);
}
