package com.vantage.elitewealth.security;

import com.vantage.elitewealth.config.AppConfig;
import com.vantage.elitewealth.exception.EliteWealthException;
import com.vantage.elitewealth.model.request.AuthRequest;
import com.vantage.elitewealth.model.response.AuthResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Fetches, caches, and auto-refreshes the EliteWealth Bearer token.
 * All client classes call {@link #getBearerToken()} before making upstream requests.
 */
@Service
public class TokenService {

    private static final Logger log = LoggerFactory.getLogger(TokenService.class);

    private final RestTemplate restTemplate;
    private final TokenStore tokenStore;
    private final AppConfig appConfig;

    // Credentials stored after first programmatic login call
    private volatile String cachedUsername;
    private volatile String cachedPassword;

    public TokenService(RestTemplate restTemplate, TokenStore tokenStore, AppConfig appConfig) {
        this.restTemplate = restTemplate;
        this.tokenStore = tokenStore;
        this.appConfig = appConfig;
    }

    /**
     * Returns a valid Bearer token string, refreshing if near expiry.
     * Throws {@link EliteWealthException} if no credentials have been authenticated yet.
     */
    public synchronized String getBearerToken() {
        if (tokenStore.isExpiredOrAboutToExpire(appConfig.getTokenRefreshBufferSeconds())) {
            if (cachedUsername == null) {
                throw new EliteWealthException(
                        "No active session. Please authenticate first via POST /auth/token",
                        HttpStatus.UNAUTHORIZED);
            }
            log.info("Token expired or near expiry — refreshing");
            authenticate(cachedUsername, cachedPassword);
        }
        return tokenStore.getAccessToken();
    }

    /**
     * Performs the upstream authentication call and stores the resulting token.
     *
     * @return the full AuthResponse from EliteWealth
     */
    public AuthResponse authenticate(String username, String password) {
        log.info("Authenticating with EliteWealth as user '{}'", username);

        AuthRequest request = new AuthRequest();
        request.setUsername(username);
        request.setPassword(password);

        ResponseEntity<AuthResponse> response;
        try {
            response = restTemplate.postForEntity(appConfig.getAuthUrl(), request, AuthResponse.class);
        } catch (Exception ex) {
            throw new EliteWealthException("Authentication request to EliteWealth failed: " + ex.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR, ex);
        }

        AuthResponse body = response.getBody();
        if (body == null || body.getAccessToken() == null) {
            throw new EliteWealthException("EliteWealth returned empty auth response", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        long validity = body.getAccessTokenValidityInSeconds() != null
                ? body.getAccessTokenValidityInSeconds()
                : 3600L;

        tokenStore.store(body.getAccessToken(), body.getRefreshToken(), validity);

        // Cache credentials for auto-refresh
        this.cachedUsername = username;
        this.cachedPassword = password;

        log.info("Authentication successful. Token valid for {} seconds", validity);
        return body;
    }

    /**
     * Clears the stored token (logout).
     */
    public void clearToken() {
        tokenStore.clear();
        cachedUsername = null;
        cachedPassword = null;
    }
}
