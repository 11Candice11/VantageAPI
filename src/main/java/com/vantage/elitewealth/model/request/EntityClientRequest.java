package com.vantage.elitewealth.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class EntityClientRequest {

    @JsonProperty("EntityId")
    private Long entityId;

    @JsonProperty("ClientDetails")
    private Map<String, Object> clientDetails;

    public EntityClientRequest() {}

    public Long getEntityId() { return entityId; }
    public void setEntityId(Long entityId) { this.entityId = entityId; }

    public Map<String, Object> getClientDetails() { return clientDetails; }
    public void setClientDetails(Map<String, Object> clientDetails) { this.clientDetails = clientDetails; }
}
