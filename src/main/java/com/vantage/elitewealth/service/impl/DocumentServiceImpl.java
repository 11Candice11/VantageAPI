package com.vantage.elitewealth.service.impl;

import com.vantage.elitewealth.client.DocumentClient;
import com.vantage.elitewealth.service.DocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentClient documentClient;

    public DocumentServiceImpl(DocumentClient documentClient) {
        this.documentClient = documentClient;
    }

    @Override
    public Map<String, Object> uploadDocument(String modelJson, MultipartFile file) throws IOException {
        return documentClient.uploadDocument(modelJson, file);
    }

    @Override
    public ResponseEntity<byte[]> downloadDocument(Long documentId) {
        return documentClient.downloadDocument(documentId);
    }
}
