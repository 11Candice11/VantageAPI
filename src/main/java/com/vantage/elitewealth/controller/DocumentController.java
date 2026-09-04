package com.vantage.elitewealth.controller;

import com.vantage.elitewealth.service.DocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    /**
     * POST /api/documents/upload
     * Accepts multipart/form-data with modelJson (string) and file (binary).
     */
    @PostMapping("/upload")
    public ResponseEntity<Map<String, Object>> upload(
            @RequestParam("modelJson") String modelJson,
            @RequestParam("file") MultipartFile file) throws IOException {
        return ResponseEntity.ok(documentService.uploadDocument(modelJson, file));
    }

    /**
     * GET /api/documents/{documentId}/download
     */
    @GetMapping("/{documentId}/download")
    public ResponseEntity<byte[]> download(@PathVariable Long documentId) {
        return documentService.downloadDocument(documentId);
    }
}
