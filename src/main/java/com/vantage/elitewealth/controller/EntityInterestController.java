package com.vantage.elitewealth.controller;

import com.vantage.elitewealth.model.request.InterestRequest;
import com.vantage.elitewealth.service.EntityInterestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/entities/{entityId}/interests")
public class EntityInterestController {

    private final EntityInterestService entityInterestService;

    public EntityInterestController(EntityInterestService entityInterestService) {
        this.entityInterestService = entityInterestService;
    }

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAll(@PathVariable Long entityId) {
        return ResponseEntity.ok(entityInterestService.getInterests(entityId));
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(
            @PathVariable Long entityId,
            @RequestBody InterestRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(entityInterestService.createInterest(entityId, request));
    }

    @GetMapping("/{interestId}")
    public ResponseEntity<Map<String, Object>> getOne(
            @PathVariable Long entityId,
            @PathVariable Long interestId) {
        return ResponseEntity.ok(entityInterestService.getInterest(entityId, interestId));
    }

    @DeleteMapping("/{interestId}")
    public ResponseEntity<Void> delete(
            @PathVariable Long entityId,
            @PathVariable Long interestId) {
        entityInterestService.deleteInterest(entityId, interestId);
        return ResponseEntity.noContent().build();
    }
}
