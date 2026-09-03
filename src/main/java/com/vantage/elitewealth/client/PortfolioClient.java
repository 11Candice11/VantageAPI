package com.vantage.elitewealth.client;

import com.vantage.elitewealth.model.request.PortfolioExtractRequest;
import com.vantage.elitewealth.model.response.PortfolioExtractResponse;
import com.vantage.elitewealth.security.TokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PortfolioClient extends BaseEliteWealthClient {

    private final RestTemplate restTemplate;

    @Value("${elitewealth.base-url}")
    private String baseUrl;

    public PortfolioClient(RestTemplate restTemplate, TokenService tokenService) {
        super(tokenService);
        this.restTemplate = restTemplate;
    }

    /**
     * POST /restApiData/Portfolio/Extract
     */
    public PortfolioExtractResponse extract(PortfolioExtractRequest request) {
        String url = baseUrl + "/restApiData/Portfolio/Extract";
        ResponseEntity<PortfolioExtractResponse> response = restTemplate.exchange(
                url, HttpMethod.POST, authorizedEntity(request), PortfolioExtractResponse.class);
        return response.getBody();
    }
}
