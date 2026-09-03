package com.vantage.elitewealth.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressRequest {

    @JsonProperty("AddressTypeId")
    private Long addressTypeId;

    @JsonProperty("Line1")
    private String line1;

    @JsonProperty("Line2")
    private String line2;

    @JsonProperty("Line3")
    private String line3;

    @JsonProperty("City")
    private String city;

    @JsonProperty("PostalCode")
    private String postalCode;

    @JsonProperty("CountryCode")
    private String countryCode;

    @JsonProperty("IsPrimary")
    private Boolean isPrimary;

    public AddressRequest() {}

    public Long getAddressTypeId() { return addressTypeId; }
    public void setAddressTypeId(Long addressTypeId) { this.addressTypeId = addressTypeId; }

    public String getLine1() { return line1; }
    public void setLine1(String line1) { this.line1 = line1; }

    public String getLine2() { return line2; }
    public void setLine2(String line2) { this.line2 = line2; }

    public String getLine3() { return line3; }
    public void setLine3(String line3) { this.line3 = line3; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public String getCountryCode() { return countryCode; }
    public void setCountryCode(String countryCode) { this.countryCode = countryCode; }

    public Boolean getIsPrimary() { return isPrimary; }
    public void setIsPrimary(Boolean isPrimary) { this.isPrimary = isPrimary; }
}
