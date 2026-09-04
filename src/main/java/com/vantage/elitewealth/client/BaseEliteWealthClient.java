package com.vantage.elitewealth.client;

import com.vantage.elitewealth.security.TokenService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

/**
 * Base helper that all EliteWealth client classes extend.
 * Provides a factory for authenticated HttpEntity objects.
 */
public abstract class BaseEliteWealthClient {

    protected final TokenService tokenService;

    protected BaseEliteWealthClient(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    /**
     * Returns an HttpEntity with Authorization: Bearer, api-key, and Content-Type: application/json headers,
     * plus the supplied request body.
     */
    protected <T> HttpEntity<T> authorizedEntity(T body) {
        HttpHeaders headers = bearerHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(body, headers);
    }

    /**
     * Returns an HttpEntity with only headers (no body) — used for GET / DELETE.
     */
    protected HttpEntity<Void> authorizedEntity() {
        return new HttpEntity<>(bearerHeaders());
    }

    private HttpHeaders bearerHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(tokenService.getBearerToken());
        return headers;
    }
}
