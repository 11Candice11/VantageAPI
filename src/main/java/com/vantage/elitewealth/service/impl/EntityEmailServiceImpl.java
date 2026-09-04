package com.vantage.elitewealth.service.impl;

import com.vantage.elitewealth.client.EntityEmailClient;
import com.vantage.elitewealth.model.request.EmailRequest;
import com.vantage.elitewealth.service.EntityEmailService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EntityEmailServiceImpl implements EntityEmailService {

    private final EntityEmailClient entityEmailClient;

    public EntityEmailServiceImpl(EntityEmailClient entityEmailClient) {
        this.entityEmailClient = entityEmailClient;
    }

    @Override
    public List<Map<String, Object>> getEmails(Long entityId) {
        return entityEmailClient.getEmails(entityId);
    }

    @Override
    public Map<String, Object> createEmail(Long entityId, EmailRequest request) {
        return entityEmailClient.createEmail(entityId, request);
    }

    @Override
    public Map<String, Object> getEmail(Long entityId, Long eMailId) {
        return entityEmailClient.getEmail(entityId, eMailId);
    }

    @Override
    public void deleteEmail(Long entityId, Long eMailId) {
        entityEmailClient.deleteEmail(entityId, eMailId);
    }
}
