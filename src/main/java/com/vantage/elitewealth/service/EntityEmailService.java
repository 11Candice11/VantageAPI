package com.vantage.elitewealth.service;

import com.vantage.elitewealth.model.request.EmailRequest;

import java.util.List;
import java.util.Map;

public interface EntityEmailService {
    List<Map<String, Object>> getEmails(Long entityId);
    Map<String, Object> createEmail(Long entityId, EmailRequest request);
    Map<String, Object> getEmail(Long entityId, Long eMailId);
    void deleteEmail(Long entityId, Long eMailId);
}
