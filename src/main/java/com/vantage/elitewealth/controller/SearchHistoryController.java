package com.vantage.elitewealth.controller;

import com.vantage.elitewealth.db.SearchedClient;
import com.vantage.elitewealth.db.SearchedClientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * CRUD for the local search-history database.
 */
@RestController
@RequestMapping("/api/search-history")
public class SearchHistoryController {

    private final SearchedClientRepository repo;

    public SearchHistoryController(SearchedClientRepository repo) {
        this.repo = repo;
    }

    /** GET /api/search-history — most recent 20 unique searches */
    @GetMapping
    public ResponseEntity<List<SearchedClient>> getRecent() {
        return ResponseEntity.ok(repo.findTop20ByOrderBySearchedAtDesc());
    }

    /** GET /api/search-history/unique — deduped by entity ID, most recent per entity */
    @GetMapping("/unique")
    public ResponseEntity<List<SearchedClient>> getUnique() {
        return ResponseEntity.ok(repo.findLatestPerEntity());
    }

    /**
     * POST /api/search-history
     * Called by the frontend whenever a search result is clicked.
     */
    @PostMapping
    public ResponseEntity<SearchedClient> save(@RequestBody Map<String, Object> body) {
        SearchedClient client = new SearchedClient(
                str(body, "entityId"),
                str(body, "entityName"),
                str(body, "firstNames"),
                str(body, "surname"),
                str(body, "idNumber"),
                str(body, "entityType"),
                str(body, "preferredEmail"),
                str(body, "searchQuery")
        );
        return ResponseEntity.ok(repo.save(client));
    }

    /** DELETE /api/search-history/{id} */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /** DELETE /api/search-history — clear all history */
    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        repo.deleteAll();
        return ResponseEntity.noContent().build();
    }

    private static String str(Map<String, Object> m, String key) {
        Object v = m.get(key);
        return v != null ? v.toString() : null;
    }
}
