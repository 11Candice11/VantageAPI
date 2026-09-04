package com.vantage.elitewealth.service.impl;

import com.vantage.elitewealth.client.EntityReviewClient;
import com.vantage.elitewealth.service.EntityReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntityReviewServiceImpl implements EntityReviewService {

    private final EntityReviewClient entityReviewClient;

    public EntityReviewServiceImpl(EntityReviewClient entityReviewClient) {
        this.entityReviewClient = entityReviewClient;
    }

    @Override
    public List<Object> getReviews(Long entityId) {
        return entityReviewClient.getReviews(entityId);
    }
}
