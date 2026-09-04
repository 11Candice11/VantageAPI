package com.vantage.elitewealth.controller;

import com.vantage.elitewealth.client.EntitySearchClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/entities")
public class EntitySearchController {

    private final EntitySearchClient entitySearchClient;

    public EntitySearchController(EntitySearchClient entitySearchClient) {
        this.entitySearchClient = entitySearchClient;
    }

    /** GET /api/entities/search?searchString=... */
    @GetMapping("/search")
    public ResponseEntity<List<Map<String, Object>>> search(@RequestParam String searchString) {
        if (searchString == null || searchString.trim().isEmpty()) {
            return ResponseEntity.ok(List.of());
        }
        return ResponseEntity.ok(entitySearchClient.searchEntity(searchString));
    }

    /** GET /api/entities/search-staff?searchString=... */
    @GetMapping("/search-staff")
    public ResponseEntity<List<Map<String, Object>>> searchStaff(@RequestParam String searchString) {
        if (searchString == null || searchString.trim().isEmpty()) {
            return ResponseEntity.ok(List.of());
        }
        return ResponseEntity.ok(entitySearchClient.searchStaff(searchString));
    }

    /** GET /api/entities/search-restricted */
    @GetMapping("/search-restricted")
    public ResponseEntity<List<Map<String, Object>>> searchRestricted() {
        return ResponseEntity.ok(entitySearchClient.searchRestrictedEntity());
    }

    /** GET /api/entities/search-restricted-by-id */
    @GetMapping("/search-restricted-by-id")
    public ResponseEntity<List<Map<String, Object>>> searchRestrictedById() {
        return ResponseEntity.ok(entitySearchClient.searchRestrictedEntityByIdOrPassportOrRegistrationNumber());
    }

    /** GET /api/entities/{userName}/check-user */
    @GetMapping("/{userName}/check-user")
    public ResponseEntity<Map<String, Object>> checkUserExists(@PathVariable String userName) {
        return ResponseEntity.ok(entitySearchClient.checkIfUserExists(userName));
    }
}
