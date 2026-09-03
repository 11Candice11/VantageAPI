package com.vantage.elitewealth.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EntityRelationRequest {

    @JsonProperty("RelatedEntityId")
    private Long relatedEntityId;

    @JsonProperty("RelationTypeId")
    private Long relationTypeId;

    @JsonProperty("StartDate")
    private String startDate;

    @JsonProperty("EndDate")
    private String endDate;

    public EntityRelationRequest() {}

    public Long getRelatedEntityId() { return relatedEntityId; }
    public void setRelatedEntityId(Long relatedEntityId) { this.relatedEntityId = relatedEntityId; }

    public Long getRelationTypeId() { return relationTypeId; }
    public void setRelationTypeId(Long relationTypeId) { this.relationTypeId = relationTypeId; }

    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }

    public String getEndDate() { return endDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }
}
