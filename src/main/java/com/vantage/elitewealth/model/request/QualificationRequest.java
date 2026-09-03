package com.vantage.elitewealth.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QualificationRequest {

    @JsonProperty("QualificationTypeId")
    private Long qualificationTypeId;

    @JsonProperty("InstitutionName")
    private String institutionName;

    @JsonProperty("YearObtained")
    private Integer yearObtained;

    @JsonProperty("Description")
    private String description;

    public QualificationRequest() {}

    public Long getQualificationTypeId() { return qualificationTypeId; }
    public void setQualificationTypeId(Long qualificationTypeId) { this.qualificationTypeId = qualificationTypeId; }

    public String getInstitutionName() { return institutionName; }
    public void setInstitutionName(String institutionName) { this.institutionName = institutionName; }

    public Integer getYearObtained() { return yearObtained; }
    public void setYearObtained(Integer yearObtained) { this.yearObtained = yearObtained; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
