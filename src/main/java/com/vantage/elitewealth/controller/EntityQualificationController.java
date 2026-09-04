package com.vantage.elitewealth.controller;

import com.vantage.elitewealth.model.request.QualificationRequest;
import com.vantage.elitewealth.service.EntityQualificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/entities/{entityId}/qualifications")
public class EntityQualificationController {

    private final EntityQualificationService entityQualificationService;

    public EntityQualificationController(EntityQualificationService entityQualificationService) {
        this.entityQualificationService = entityQualificationService;
    }

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAll(@PathVariable Long entityId) {
        return ResponseEntity.ok(entityQualificationService.getQualifications(entityId));
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(
            @PathVariable Long entityId,
            @RequestBody QualificationRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(entityQualificationService.createQualification(entityId, request));
    }

    @GetMapping("/{qualificationId}")
    public ResponseEntity<Map<String, Object>> getOne(
            @PathVariable Long entityId,
            @PathVariable Long qualificationId) {
        return ResponseEntity.ok(entityQualificationService.getQualification(entityId, qualificationId));
    }

    @DeleteMapping("/{qualificationId}")
    public ResponseEntity<Void> delete(
            @PathVariable Long entityId,
            @PathVariable Long qualificationId) {
        entityQualificationService.deleteQualification(entityId, qualificationId);
        return ResponseEntity.noContent().build();
    }
}
