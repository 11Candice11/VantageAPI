package com.vantage.elitewealth.client;

import com.vantage.elitewealth.security.TokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Component
public class DocumentClient extends BaseEliteWealthClient {

    private final RestTemplate restTemplate;

    @Value("${elitewealth.base-url}")
    private String baseUrl;

    public DocumentClient(RestTemplate restTemplate, TokenService tokenService) {
        super(tokenService);
        this.restTemplate = restTemplate;
    }

    /**
     * POST /restApiData/Document/upload
     * Sends modelJson string and binary file as a multipart/form-data request.
     */
    public Map<String, Object> uploadDocument(String modelJson, MultipartFile file) throws IOException {
        String url = baseUrl + "/restApiData/Document/upload";

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(tokenService.getBearerToken());
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("modelJson", modelJson);

        ByteArrayResource fileResource = new ByteArrayResource(file.getBytes()) {
            @Override
            public String getFilename() {
                return file.getOriginalFilename();
            }
        };
        HttpHeaders fileHeaders = new HttpHeaders();
        fileHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        HttpEntity<ByteArrayResource> filePart = new HttpEntity<>(fileResource, fileHeaders);
        body.add("File1", filePart);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        @SuppressWarnings("unchecked")
        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Map.class);
        @SuppressWarnings("unchecked")
        Map<String, Object> result = response.getBody();
        return result;
    }

    /**
     * GET /restApiData/Document/download/{documentId}
     * Returns raw bytes with original content-disposition preserved.
     */
    public ResponseEntity<byte[]> downloadDocument(Long documentId) {
        String url = baseUrl + "/restApiData/Document/download/" + documentId;
        ResponseEntity<byte[]> upstreamResponse = restTemplate.exchange(
                url, HttpMethod.GET, authorizedEntity(), byte[].class);

        // Propagate content-disposition and content-type from upstream
        HttpHeaders responseHeaders = new HttpHeaders();
        if (upstreamResponse.getHeaders().getContentDisposition() != null) {
            responseHeaders.setContentDisposition(upstreamResponse.getHeaders().getContentDisposition());
        }
        MediaType contentType = upstreamResponse.getHeaders().getContentType();
        responseHeaders.setContentType(contentType != null ? contentType : MediaType.APPLICATION_OCTET_STREAM);

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(upstreamResponse.getBody());
    }
}
