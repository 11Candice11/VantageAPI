package com.vantage.elitewealth.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TelephoneRequest {

    @JsonProperty("TelephoneTypeId")
    private Long telephoneTypeId;

    @JsonProperty("CountryCode")
    private String countryCode;

    @JsonProperty("AreaCode")
    private String areaCode;

    @JsonProperty("Number")
    private String number;

    @JsonProperty("IsPrimary")
    private Boolean isPrimary;

    public TelephoneRequest() {}

    public Long getTelephoneTypeId() { return telephoneTypeId; }
    public void setTelephoneTypeId(Long telephoneTypeId) { this.telephoneTypeId = telephoneTypeId; }

    public String getCountryCode() { return countryCode; }
    public void setCountryCode(String countryCode) { this.countryCode = countryCode; }

    public String getAreaCode() { return areaCode; }
    public void setAreaCode(String areaCode) { this.areaCode = areaCode; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public Boolean getIsPrimary() { return isPrimary; }
    public void setIsPrimary(Boolean isPrimary) { this.isPrimary = isPrimary; }
}
