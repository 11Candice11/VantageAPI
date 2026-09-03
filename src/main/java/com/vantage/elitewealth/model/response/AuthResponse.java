package com.vantage.elitewealth.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthResponse {

    @JsonProperty("AccessToken")
    private String accessToken;

    @JsonProperty("RefreshToken")
    private String refreshToken;

    @JsonProperty("AccessTokenValidityInSeconds")
    private Long accessTokenValidityInSeconds;

    @JsonProperty("RefreshTokenValidityInSeconds")
    private Long refreshTokenValidityInSeconds;

    @JsonProperty("TokenType")
    private String tokenType;

    public AuthResponse() {}

    public String getAccessToken() { return accessToken; }
    public void setAccessToken(String accessToken) { this.accessToken = accessToken; }

    public String getRefreshToken() { return refreshToken; }
    public void setRefreshToken(String refreshToken) { this.refreshToken = refreshToken; }

    public Long getAccessTokenValidityInSeconds() { return accessTokenValidityInSeconds; }
    public void setAccessTokenValidityInSeconds(Long accessTokenValidityInSeconds) {
        this.accessTokenValidityInSeconds = accessTokenValidityInSeconds;
    }

    public Long getRefreshTokenValidityInSeconds() { return refreshTokenValidityInSeconds; }
    public void setRefreshTokenValidityInSeconds(Long refreshTokenValidityInSeconds) {
        this.refreshTokenValidityInSeconds = refreshTokenValidityInSeconds;
    }

    public String getTokenType() { return tokenType; }
    public void setTokenType(String tokenType) { this.tokenType = tokenType; }
}
