package com.vantage.elitewealth.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StaffRelationRequest {

    @JsonProperty("StaffEntityId")
    private Long staffEntityId;

    @JsonProperty("RelationTypeId")
    private Long relationTypeId;

    @JsonProperty("IsPrimary")
    private Boolean isPrimary;

    public StaffRelationRequest() {}

    public Long getStaffEntityId() { return staffEntityId; }
    public void setStaffEntityId(Long staffEntityId) { this.staffEntityId = staffEntityId; }

    public Long getRelationTypeId() { return relationTypeId; }
    public void setRelationTypeId(Long relationTypeId) { this.relationTypeId = relationTypeId; }

    public Boolean getIsPrimary() { return isPrimary; }
    public void setIsPrimary(Boolean isPrimary) { this.isPrimary = isPrimary; }
}
