package com.vantage.elitewealth.security;

import com.vantage.elitewealth.config.AppConfig;
import com.vantage.elitewealth.exception.EliteWealthException;
import com.vantage.elitewealth.model.request.AuthRequest;
import com.vantage.elitewealth.model.response.AuthResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.annotation.PostConstruct;

/**
 * Fetches, caches, and auto-refreshes the EliteWealth Bearer token.
 * Bootstraps on startup using the service-account credentials so the token
 * is available before any UI login occurs.
 */
@Service
public class TokenService {

    private static final Logger log = LoggerFactory.getLogger(TokenService.class);

    private final RestTemplate restTemplate;
    private final TokenStore tokenStore;
    private final AppConfig appConfig;

    @Value("${elitewealth.api-key}")
    private String apiKey;

    @Value("${elitewealth.service.username}")
    private String serviceUsername;

    @Value("${elitewealth.service.password}")
    private String servicePassword;

    private volatile String cachedUsername;
    private volatile String cachedPassword;

    public TokenService(RestTemplate restTemplate, TokenStore tokenStore, AppConfig appConfig) {
        this.restTemplate = restTemplate;
        this.tokenStore = tokenStore;
        this.appConfig = appConfig;
    }

    /**
     * Bootstrap the token at startup so all API calls work immediately.
     */
    @PostConstruct
    public void bootstrap() {
        try {
            log.info("Bootstrapping EliteWealth service-account token on startup");
            authenticate(serviceUsername, servicePassword);
        } catch (Exception ex) {
            log.warn("Could not bootstrap EliteWealth token on startup: {}. Token will be fetched on first login.", ex.getMessage());
        }
    }

    /**
     * Returns a valid Bearer token string, refreshing if near expiry.
     */
    public synchronized String getBearerToken() {
        if (tokenStore.isExpiredOrAboutToExpire(appConfig.getTokenRefreshBufferSeconds())) {
            String user = cachedUsername != null ? cachedUsername : serviceUsername;
            String pass = cachedPassword != null ? cachedPassword : servicePassword;
            log.info("Token expired or near expiry — refreshing");
            authenticate(user, pass);
        }
        return tokenStore.getAccessToken();
    }

    /**
     * Performs the upstream authentication call and stores the resulting token.
     */
    public AuthResponse authenticate(String username, String password) {
        log.info("Authenticating with EliteWealth as user '{}'", username);

        AuthRequest request = new AuthRequest();
        request.setUsername(username);
        request.setPassword(password);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Accept", "*/*");
        headers.set("api-key", apiKey);

        HttpEntity<AuthRequest> entity = new HttpEntity<>(request, headers);

        ResponseEntity<AuthResponse> response;
        try {
            response = restTemplate.exchange(
                    appConfig.getAuthUrl(),
                    HttpMethod.POST,
                    entity,
                    AuthResponse.class);
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
        this.cachedUsername = username;
        this.cachedPassword = password;

        log.info("Authentication successful. Token valid for {} seconds", validity);
        return body;
    }

    public void clearToken() {
        tokenStore.clear();
        cachedUsername = null;
        cachedPassword = null;
    }
}
