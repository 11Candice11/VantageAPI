package com.vantage.elitewealth.service;

import com.vantage.elitewealth.model.request.TelephoneRequest;

import java.util.List;
import java.util.Map;

public interface EntityTelephoneService {
    List<Map<String, Object>> getTelephones(Long entityId);
    Map<String, Object> createTelephone(Long entityId, TelephoneRequest request);
    Map<String, Object> getTelephone(Long entityId, Long telephoneId);
    void deleteTelephone(Long entityId, Long telephoneId);
}
