package com.vantage.elitewealth.controller;

import com.vantage.elitewealth.model.request.EntityRelationRequest;
import com.vantage.elitewealth.service.EntityRelationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/entities/{entityId}/relations")
public class EntityRelationController {

    private final EntityRelationService entityRelationService;

    public EntityRelationController(EntityRelationService entityRelationService) {
        this.entityRelationService = entityRelationService;
    }

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAll(@PathVariable Long entityId) {
        return ResponseEntity.ok(entityRelationService.getRelations(entityId));
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(
            @PathVariable Long entityId,
            @RequestBody EntityRelationRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(entityRelationService.createRelation(entityId, request));
    }

    @GetMapping("/inverse")
    public ResponseEntity<List<Map<String, Object>>> getInverse(@PathVariable Long entityId) {
        return ResponseEntity.ok(entityRelationService.getInverseRelations(entityId));
    }

    @GetMapping("/get")
    public ResponseEntity<Map<String, Object>> get(@PathVariable Long entityId) {
        return ResponseEntity.ok(entityRelationService.getRelation(entityId));
    }
}
