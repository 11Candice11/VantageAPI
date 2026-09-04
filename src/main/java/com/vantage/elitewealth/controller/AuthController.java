package com.vantage.elitewealth.controller;

import com.vantage.elitewealth.model.request.AuthRequest;
import com.vantage.elitewealth.model.response.AuthResponse;
import com.vantage.elitewealth.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * POST /api/auth/token
     * Authenticates with EliteWealth and stores the token for subsequent calls.
     */
    @PostMapping("/token")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
