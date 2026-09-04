package com.vantage.elitewealth.controller;

import com.vantage.elitewealth.model.request.EmailRequest;
import com.vantage.elitewealth.service.EntityEmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/entities/{entityId}/emails")
public class EntityEmailController {

    private final EntityEmailService entityEmailService;

    public EntityEmailController(EntityEmailService entityEmailService) {
        this.entityEmailService = entityEmailService;
    }

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAll(@PathVariable Long entityId) {
        return ResponseEntity.ok(entityEmailService.getEmails(entityId));
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(
            @PathVariable Long entityId,
            @RequestBody EmailRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(entityEmailService.createEmail(entityId, request));
    }

    @GetMapping("/{eMailId}")
    public ResponseEntity<Map<String, Object>> getOne(
            @PathVariable Long entityId,
            @PathVariable Long eMailId) {
        return ResponseEntity.ok(entityEmailService.getEmail(entityId, eMailId));
    }

    @DeleteMapping("/{eMailId}")
    public ResponseEntity<Void> delete(
            @PathVariable Long entityId,
            @PathVariable Long eMailId) {
        entityEmailService.deleteEmail(entityId, eMailId);
        return ResponseEntity.noContent().build();
    }
}
