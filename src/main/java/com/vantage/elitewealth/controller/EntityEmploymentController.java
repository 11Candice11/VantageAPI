package com.vantage.elitewealth.controller;

import com.vantage.elitewealth.model.request.EmploymentRequest;
import com.vantage.elitewealth.service.EntityEmploymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/entities/{entityId}/employment-history")
public class EntityEmploymentController {

    private final EntityEmploymentService entityEmploymentService;

    public EntityEmploymentController(EntityEmploymentService entityEmploymentService) {
        this.entityEmploymentService = entityEmploymentService;
    }

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAll(@PathVariable Long entityId) {
        return ResponseEntity.ok(entityEmploymentService.getEmploymentHistory(entityId));
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(
            @PathVariable Long entityId,
            @RequestBody EmploymentRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(entityEmploymentService.createEmployment(entityId, request));
    }

    @GetMapping("/{employmentId}")
    public ResponseEntity<Map<String, Object>> getOne(
            @PathVariable Long entityId,
            @PathVariable Long employmentId) {
        return ResponseEntity.ok(entityEmploymentService.getEmployment(entityId, employmentId));
    }

    @DeleteMapping("/{employmentId}")
    public ResponseEntity<Void> delete(
            @PathVariable Long entityId,
            @PathVariable Long employmentId) {
        entityEmploymentService.deleteEmployment(entityId, employmentId);
        return ResponseEntity.noContent().build();
    }
}
