package com.vantage.elitewealth.controller;

import com.vantage.elitewealth.model.request.StaffRelationRequest;
import com.vantage.elitewealth.service.EntityStaffRelationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/entities/{entityId}/staff-relations")
public class EntityStaffRelationController {

    private final EntityStaffRelationService entityStaffRelationService;

    public EntityStaffRelationController(EntityStaffRelationService entityStaffRelationService) {
        this.entityStaffRelationService = entityStaffRelationService;
    }

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAll(@PathVariable Long entityId) {
        return ResponseEntity.ok(entityStaffRelationService.getClientStaffRelations(entityId));
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(
            @PathVariable Long entityId,
            @RequestBody StaffRelationRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(entityStaffRelationService.createClientStaffRelation(entityId, request));
    }

    @GetMapping("/get")
    public ResponseEntity<Map<String, Object>> get(@PathVariable Long entityId) {
        return ResponseEntity.ok(entityStaffRelationService.getClientStaffRelation(entityId));
    }

    @GetMapping("/staff-member-clients")
    public ResponseEntity<List<Map<String, Object>>> getStaffClients(@PathVariable Long entityId) {
        return ResponseEntity.ok(entityStaffRelationService.getStaffMemberClients(entityId));
    }
}
