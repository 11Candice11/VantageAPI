package com.vantage.elitewealth.service.impl;

import com.vantage.elitewealth.client.PortfolioClient;
import com.vantage.elitewealth.model.request.PortfolioExtractRequest;
import com.vantage.elitewealth.model.response.PortfolioExtractResponse;
import com.vantage.elitewealth.service.PortfolioService;
import org.springframework.stereotype.Service;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    private final PortfolioClient portfolioClient;

    public PortfolioServiceImpl(PortfolioClient portfolioClient) {
        this.portfolioClient = portfolioClient;
    }

    @Override
    public PortfolioExtractResponse extract(PortfolioExtractRequest request) {
        return portfolioClient.extract(request);
    }
}
