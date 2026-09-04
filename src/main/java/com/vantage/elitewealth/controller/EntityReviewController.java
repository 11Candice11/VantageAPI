package com.vantage.elitewealth.controller;

import com.vantage.elitewealth.service.EntityReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entities/{entityId}/reviews")
public class EntityReviewController {

    private final EntityReviewService entityReviewService;

    public EntityReviewController(EntityReviewService entityReviewService) {
        this.entityReviewService = entityReviewService;
    }

    @GetMapping
    public ResponseEntity<List<Object>> getAll(@PathVariable Long entityId) {
        return ResponseEntity.ok(entityReviewService.getReviews(entityId));
    }
}
