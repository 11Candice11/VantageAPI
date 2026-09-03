package com.vantage.elitewealth.service;

import com.vantage.elitewealth.model.request.PortfolioExtractRequest;
import com.vantage.elitewealth.model.response.PortfolioExtractResponse;

public interface PortfolioService {
    PortfolioExtractResponse extract(PortfolioExtractRequest request);
}
