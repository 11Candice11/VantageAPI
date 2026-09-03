package com.vantage.elitewealth.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InterestRequest {

    @JsonProperty("InterestTypeId")
    private Long interestTypeId;

    @JsonProperty("Description")
    private String description;

    public InterestRequest() {}

    public Long getInterestTypeId() { return interestTypeId; }
    public void setInterestTypeId(Long interestTypeId) { this.interestTypeId = interestTypeId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
