package com.vantage.elitewealth.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmploymentRequest {

    @JsonProperty("EmployerName")
    private String employerName;

    @JsonProperty("JobTitle")
    private String jobTitle;

    @JsonProperty("StartDate")
    private String startDate;

    @JsonProperty("EndDate")
    private String endDate;

    @JsonProperty("IsCurrent")
    private Boolean isCurrent;

    @JsonProperty("IndustryTypeId")
    private Long industryTypeId;

    public EmploymentRequest() {}

    public String getEmployerName() { return employerName; }
    public void setEmployerName(String employerName) { this.employerName = employerName; }

    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }

    public String getEndDate() { return endDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }

    public Boolean getIsCurrent() { return isCurrent; }
    public void setIsCurrent(Boolean isCurrent) { this.isCurrent = isCurrent; }

    public Long getIndustryTypeId() { return industryTypeId; }
    public void setIndustryTypeId(Long industryTypeId) { this.industryTypeId = industryTypeId; }
}
