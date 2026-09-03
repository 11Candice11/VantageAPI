package com.vantage.elitewealth.client;

import com.vantage.elitewealth.model.request.AuthRequest;
import com.vantage.elitewealth.model.response.AuthResponse;
import com.vantage.elitewealth.security.TokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * HTTP client for the EliteWealth authentication endpoint.
 * Note: this client does NOT call getBearerToken() — auth is pre-token.
 */
@Component
public class AuthClient {

    private final RestTemplate restTemplate;
    private final TokenService tokenService;

    @Value("${elitewealth.auth-url}")
    private String authUrl;

    public AuthClient(RestTemplate restTemplate, TokenService tokenService) {
        this.restTemplate = restTemplate;
        this.tokenService = tokenService;
    }

    /**
     * Delegates directly to TokenService which owns the upstream auth call and token storage.
     */
    public AuthResponse authenticate(AuthRequest request) {
        return tokenService.authenticate(request.getUsername(), request.getPassword());
    }
}
