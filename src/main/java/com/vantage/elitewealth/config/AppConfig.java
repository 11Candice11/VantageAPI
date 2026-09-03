package com.vantage.elitewealth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${elitewealth.base-url}")
    private String baseUrl;

    @Value("${elitewealth.auth-url}")
    private String authUrl;

    @Value("${elitewealth.token.refresh-buffer-seconds:60}")
    private long tokenRefreshBufferSeconds;

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getAuthUrl() {
        return authUrl;
    }

    public long getTokenRefreshBufferSeconds() {
        return tokenRefreshBufferSeconds;
    }
}
