package com.vantage.elitewealth.service;

import com.vantage.elitewealth.model.request.EmploymentRequest;

import java.util.List;
import java.util.Map;

public interface EntityEmploymentService {
    List<Map<String, Object>> getEmploymentHistory(Long entityId);
    Map<String, Object> createEmployment(Long entityId, EmploymentRequest request);
    Map<String, Object> getEmployment(Long entityId, Long employmentId);
    void deleteEmployment(Long entityId, Long employmentId);
}
