package com.vantage.elitewealth.service.impl;

import com.vantage.elitewealth.client.EntityTelephoneClient;
import com.vantage.elitewealth.model.request.TelephoneRequest;
import com.vantage.elitewealth.service.EntityTelephoneService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EntityTelephoneServiceImpl implements EntityTelephoneService {

    private final EntityTelephoneClient entityTelephoneClient;

    public EntityTelephoneServiceImpl(EntityTelephoneClient entityTelephoneClient) {
        this.entityTelephoneClient = entityTelephoneClient;
    }

    @Override
    public List<Map<String, Object>> getTelephones(Long entityId) {
        return entityTelephoneClient.getTelephones(entityId);
    }

    @Override
    public Map<String, Object> createTelephone(Long entityId, TelephoneRequest request) {
        return entityTelephoneClient.createTelephone(entityId, request);
    }

    @Override
    public Map<String, Object> getTelephone(Long entityId, Long telephoneId) {
        return entityTelephoneClient.getTelephone(entityId, telephoneId);
    }

    @Override
    public void deleteTelephone(Long entityId, Long telephoneId) {
        entityTelephoneClient.deleteTelephone(entityId, telephoneId);
    }
}
