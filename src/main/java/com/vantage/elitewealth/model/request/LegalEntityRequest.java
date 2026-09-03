package com.vantage.elitewealth.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class LegalEntityRequest {

    @JsonProperty("LegalEntityId")
    private Long legalEntityId;

    @JsonProperty("RegistrationNumber")
    private String registrationNumber;

    @JsonProperty("EntityName")
    private String entityName;

    @JsonProperty("EntityTypeId")
    private Long entityTypeId;

    @JsonProperty("InceptionDate")
    private String inceptionDate;

    @JsonProperty("AdditionalFields")
    private Map<String, Object> additionalFields;

    public LegalEntityRequest() {}

    public Long getLegalEntityId() { return legalEntityId; }
    public void setLegalEntityId(Long legalEntityId) { this.legalEntityId = legalEntityId; }

    public String getRegistrationNumber() { return registrationNumber; }
    public void setRegistrationNumber(String registrationNumber) { this.registrationNumber = registrationNumber; }

    public String getEntityName() { return entityName; }
    public void setEntityName(String entityName) { this.entityName = entityName; }

    public Long getEntityTypeId() { return entityTypeId; }
    public void setEntityTypeId(Long entityTypeId) { this.entityTypeId = entityTypeId; }

    public String getInceptionDate() { return inceptionDate; }
    public void setInceptionDate(String inceptionDate) { this.inceptionDate = inceptionDate; }

    public Map<String, Object> getAdditionalFields() { return additionalFields; }
    public void setAdditionalFields(Map<String, Object> additionalFields) {
        this.additionalFields = additionalFields;
    }
}
