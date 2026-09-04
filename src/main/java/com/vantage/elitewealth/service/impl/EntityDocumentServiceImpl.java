package com.vantage.elitewealth.service.impl;

import com.vantage.elitewealth.client.EntityDocumentClient;
import com.vantage.elitewealth.service.EntityDocumentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EntityDocumentServiceImpl implements EntityDocumentService {

    private final EntityDocumentClient entityDocumentClient;

    public EntityDocumentServiceImpl(EntityDocumentClient entityDocumentClient) {
        this.entityDocumentClient = entityDocumentClient;
    }

    @Override
    public List<Map<String, Object>> getDocuments(Long entityId) {
        return entityDocumentClient.getDocuments(entityId);
    }

    @Override
    public Map<String, Object> getDocument(Long entityId, Long documentId) {
        return entityDocumentClient.getDocument(entityId, documentId);
    }
}
