package com.vantage.elitewealth.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface DocumentService {
    Map<String, Object> uploadDocument(String modelJson, MultipartFile file) throws IOException;
    ResponseEntity<byte[]> downloadDocument(Long documentId);
}
