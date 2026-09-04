package com.vantage.elitewealth.controller;

import com.vantage.elitewealth.client.EntityClientClient;
import com.vantage.elitewealth.client.EntityExtractClient;
import com.vantage.elitewealth.client.EntityLegalClient;
import com.vantage.elitewealth.client.EntityNaturalClient;
import com.vantage.elitewealth.model.request.EntityClientRequest;
import com.vantage.elitewealth.model.request.EntityExtractRequest;
import com.vantage.elitewealth.model.request.LegalEntityRequest;
import com.vantage.elitewealth.model.request.NaturalEntityRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/entities")
public class EntityController {

    private final EntityNaturalClient entityNaturalClient;
    private final EntityLegalClient entityLegalClient;
    private final EntityClientClient entityClientClient;
    private final EntityExtractClient entityExtractClient;

    public EntityController(
            EntityNaturalClient entityNaturalClient,
            EntityLegalClient entityLegalClient,
            EntityClientClient entityClientClient,
            EntityExtractClient entityExtractClient) {
        this.entityNaturalClient = entityNaturalClient;
        this.entityLegalClient = entityLegalClient;
        this.entityClientClient = entityClientClient;
        this.entityExtractClient = entityExtractClient;
    }

    // ── Natural entity ───────────────────────────────────────────────────────

    @GetMapping("/{entityId}/natural-entity-details")
    public ResponseEntity<Map<String, Object>> getNaturalDetails(@PathVariable Long entityId) {
        return ResponseEntity.ok(entityNaturalClient.getNaturalEntityDetails(entityId));
    }

    @PostMapping("/save-natural-entity-details")
    public ResponseEntity<Map<String, Object>> saveNaturalDetails(@RequestBody NaturalEntityRequest request) {
        return ResponseEntity.ok(entityNaturalClient.saveNaturalEntityDetails(request));
    }

    @PostMapping("/create-natural-entity-client")
    public ResponseEntity<Map<String, Object>> createNaturalClient(@RequestBody NaturalEntityRequest request) {
        return ResponseEntity.ok(entityNaturalClient.createNaturalEntityClient(request));
    }

    // ── Legal entity ─────────────────────────────────────────────────────────

    @GetMapping("/{legalEntityId}/legal-entity-details")
    public ResponseEntity<Map<String, Object>> getLegalDetails(@PathVariable Long legalEntityId) {
        return ResponseEntity.ok(entityLegalClient.getLegalEntityDetails(legalEntityId));
    }

    @PostMapping("/save-legal-entity-details")
    public ResponseEntity<Map<String, Object>> saveLegalDetails(@RequestBody LegalEntityRequest request) {
        return ResponseEntity.ok(entityLegalClient.saveLegalEntityDetails(request));
    }

    @PostMapping("/create-legal-entity-client")
    public ResponseEntity<Map<String, Object>> createLegalClient(@RequestBody LegalEntityRequest request) {
        return ResponseEntity.ok(entityLegalClient.createLegalEntityClient(request));
    }

    // ── Entity client ────────────────────────────────────────────────────────

    @GetMapping("/{entityId}/entity-client-details")
    public ResponseEntity<Map<String, Object>> getEntityClientDetails(@PathVariable Long entityId) {
        return ResponseEntity.ok(entityClientClient.getEntityClientDetails(entityId));
    }

    @PostMapping("/save-entity-client")
    public ResponseEntity<Map<String, Object>> saveEntityClient(@RequestBody EntityClientRequest request) {
        return ResponseEntity.ok(entityClientClient.saveEntityClient(request));
    }

    // ── Extract ──────────────────────────────────────────────────────────────

    @GetMapping("/company-extract")
    public ResponseEntity<Map<String, Object>> getCompanyExtract() {
        return ResponseEntity.ok(entityExtractClient.getCompanyExtract());
    }

    @PostMapping("/entity-extract")
    public ResponseEntity<Map<String, Object>> entityExtract(@RequestBody EntityExtractRequest request) {
        return ResponseEntity.ok(entityExtractClient.entityExtract(request));
    }
}
