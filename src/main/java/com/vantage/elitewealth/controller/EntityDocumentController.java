package com.vantage.elitewealth.controller;

import com.vantage.elitewealth.service.EntityDocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/entities/{entityId}/documents")
public class EntityDocumentController {

    private final EntityDocumentService entityDocumentService;

    public EntityDocumentController(EntityDocumentService entityDocumentService) {
        this.entityDocumentService = entityDocumentService;
    }

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAll(@PathVariable Long entityId) {
        return ResponseEntity.ok(entityDocumentService.getDocuments(entityId));
    }

    @GetMapping("/{documentId}")
    public ResponseEntity<Map<String, Object>> getOne(
            @PathVariable Long entityId,
            @PathVariable Long documentId) {
        return ResponseEntity.ok(entityDocumentService.getDocument(entityId, documentId));
    }
}
