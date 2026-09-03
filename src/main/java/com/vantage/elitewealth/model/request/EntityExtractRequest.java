package com.vantage.elitewealth.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EntityExtractRequest {

    @JsonProperty("EntityIds")
    private List<Long> entityIds;

    @JsonProperty("IncludeAddresses")
    private Boolean includeAddresses;

    @JsonProperty("IncludeContacts")
    private Boolean includeContacts;

    @JsonProperty("IncludeDocuments")
    private Boolean includeDocuments;

    public EntityExtractRequest() {}

    public List<Long> getEntityIds() { return entityIds; }
    public void setEntityIds(List<Long> entityIds) { this.entityIds = entityIds; }

    public Boolean getIncludeAddresses() { return includeAddresses; }
    public void setIncludeAddresses(Boolean includeAddresses) { this.includeAddresses = includeAddresses; }

    public Boolean getIncludeContacts() { return includeContacts; }
    public void setIncludeContacts(Boolean includeContacts) { this.includeContacts = includeContacts; }

    public Boolean getIncludeDocuments() { return includeDocuments; }
    public void setIncludeDocuments(Boolean includeDocuments) { this.includeDocuments = includeDocuments; }
}
