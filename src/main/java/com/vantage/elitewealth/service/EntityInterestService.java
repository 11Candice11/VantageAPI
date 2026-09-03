package com.vantage.elitewealth.service;

import com.vantage.elitewealth.model.request.InterestRequest;

import java.util.List;
import java.util.Map;

public interface EntityInterestService {
    List<Map<String, Object>> getInterests(Long entityId);
    Map<String, Object> createInterest(Long entityId, InterestRequest request);
    Map<String, Object> getInterest(Long entityId, Long interestId);
    void deleteInterest(Long entityId, Long interestId);
}
