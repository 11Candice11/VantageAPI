package com.vantage.elitewealth.service;

import java.util.List;
import java.util.Map;

public interface EntityDocumentService {
    List<Map<String, Object>> getDocuments(Long entityId);
    Map<String, Object> getDocument(Long entityId, Long documentId);
}
