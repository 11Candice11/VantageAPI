package com.vantage.elitewealth.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailRequest {

    @JsonProperty("EMailTypeId")
    private Long eMailTypeId;

    @JsonProperty("EMailAddress")
    private String eMailAddress;

    @JsonProperty("IsPrimary")
    private Boolean isPrimary;

    public EmailRequest() {}

    public Long getEMailTypeId() { return eMailTypeId; }
    public void setEMailTypeId(Long eMailTypeId) { this.eMailTypeId = eMailTypeId; }

    public String getEMailAddress() { return eMailAddress; }
    public void setEMailAddress(String eMailAddress) { this.eMailAddress = eMailAddress; }

    public Boolean getIsPrimary() { return isPrimary; }
    public void setIsPrimary(Boolean isPrimary) { this.isPrimary = isPrimary; }
}
