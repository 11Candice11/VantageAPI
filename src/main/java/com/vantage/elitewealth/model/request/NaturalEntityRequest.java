package com.vantage.elitewealth.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class NaturalEntityRequest {

    @JsonProperty("EntityId")
    private Long entityId;

    @JsonProperty("FirstName")
    private String firstName;

    @JsonProperty("LastName")
    private String lastName;

    @JsonProperty("IdNumber")
    private String idNumber;

    @JsonProperty("PassportNumber")
    private String passportNumber;

    @JsonProperty("DateOfBirth")
    private String dateOfBirth;

    @JsonProperty("GenderId")
    private Long genderId;

    @JsonProperty("MaritalStatusId")
    private Long maritalStatusId;

    @JsonProperty("AdditionalFields")
    private Map<String, Object> additionalFields;

    public NaturalEntityRequest() {}

    public Long getEntityId() { return entityId; }
    public void setEntityId(Long entityId) { this.entityId = entityId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getIdNumber() { return idNumber; }
    public void setIdNumber(String idNumber) { this.idNumber = idNumber; }

    public String getPassportNumber() { return passportNumber; }
    public void setPassportNumber(String passportNumber) { this.passportNumber = passportNumber; }

    public String getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public Long getGenderId() { return genderId; }
    public void setGenderId(Long genderId) { this.genderId = genderId; }

    public Long getMaritalStatusId() { return maritalStatusId; }
    public void setMaritalStatusId(Long maritalStatusId) { this.maritalStatusId = maritalStatusId; }

    public Map<String, Object> getAdditionalFields() { return additionalFields; }
    public void setAdditionalFields(Map<String, Object> additionalFields) {
        this.additionalFields = additionalFields;
    }
}
