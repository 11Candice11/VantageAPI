package com.vantage.elitewealth.controller;

import com.vantage.elitewealth.model.request.TelephoneRequest;
import com.vantage.elitewealth.service.EntityTelephoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/entities/{entityId}/telephones")
public class EntityTelephoneController {

    private final EntityTelephoneService entityTelephoneService;

    public EntityTelephoneController(EntityTelephoneService entityTelephoneService) {
        this.entityTelephoneService = entityTelephoneService;
    }

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAll(@PathVariable Long entityId) {
        return ResponseEntity.ok(entityTelephoneService.getTelephones(entityId));
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(
            @PathVariable Long entityId,
            @RequestBody TelephoneRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(entityTelephoneService.createTelephone(entityId, request));
    }

    @GetMapping("/{telephoneId}")
    public ResponseEntity<Map<String, Object>> getOne(
            @PathVariable Long entityId,
            @PathVariable Long telephoneId) {
        return ResponseEntity.ok(entityTelephoneService.getTelephone(entityId, telephoneId));
    }

    @DeleteMapping("/{telephoneId}")
    public ResponseEntity<Void> delete(
            @PathVariable Long entityId,
            @PathVariable Long telephoneId) {
        entityTelephoneService.deleteTelephone(entityId, telephoneId);
        return ResponseEntity.noContent().build();
    }
}
