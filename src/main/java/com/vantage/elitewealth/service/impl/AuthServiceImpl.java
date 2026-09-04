package com.vantage.elitewealth.service.impl;

import com.vantage.elitewealth.exception.EliteWealthException;
import com.vantage.elitewealth.model.request.AuthRequest;
import com.vantage.elitewealth.model.response.AuthResponse;
import com.vantage.elitewealth.security.TokenService;
import com.vantage.elitewealth.service.AuthService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * Local credential check — the UI logs in with app credentials (cat@gmail.com / password).
 * On success we fetch/return the real EliteWealth bearer token so the frontend
 * can attach it to every subsequent API call.
 */
@Service
public class AuthServiceImpl implements AuthService {

    private final TokenService tokenService;

    @Value("${app.local.username}")
    private String localUsername;

    @Value("${app.local.password}")
    private String localPassword;

    // EliteWealth service-account credentials used to obtain the upstream token
    @Value("${elitewealth.service.username:QGFgzP49w4DuqJmA}")
    private String serviceUsername;

    @Value("${elitewealth.service.password:QrSzh93D4wNR4BEs}")
    private String servicePassword;

    public AuthServiceImpl(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public AuthResponse authenticate(AuthRequest request) {
        // Validate local UI credentials
        if (!localUsername.equalsIgnoreCase(request.getUsername()) ||
            !localPassword.equals(request.getPassword())) {
            throw new EliteWealthException("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }

        // Fetch (or reuse cached) EliteWealth token using the service account
        return tokenService.authenticate(serviceUsername, servicePassword);
    }
}

