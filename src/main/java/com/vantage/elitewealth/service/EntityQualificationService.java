package com.vantage.elitewealth.service;

import com.vantage.elitewealth.model.request.QualificationRequest;

import java.util.List;
import java.util.Map;

public interface EntityQualificationService {
    List<Map<String, Object>> getQualifications(Long entityId);
    Map<String, Object> createQualification(Long entityId, QualificationRequest request);
    Map<String, Object> getQualification(Long entityId, Long qualificationId);
    void deleteQualification(Long entityId, Long qualificationId);
}
