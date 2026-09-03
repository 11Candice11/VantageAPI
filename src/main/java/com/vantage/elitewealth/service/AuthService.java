package com.vantage.elitewealth.service;

import com.vantage.elitewealth.model.request.AuthRequest;
import com.vantage.elitewealth.model.response.AuthResponse;

public interface AuthService {
    AuthResponse authenticate(AuthRequest request);
}
