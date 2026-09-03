package com.vantage.elitewealth.model.response;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generic wrapper for upstream list responses that may have varying field names.
 * Fields not explicitly mapped are collected in additionalProperties.
 */
public class ApiListResponse<T> {

    private List<T> items = new ArrayList<>();
    private Integer totalCount;
    private final Map<String, Object> additionalProperties = new HashMap<>();

    public ApiListResponse() {}

    public List<T> getItems() { return items; }
    public void setItems(List<T> items) { this.items = items; }

    public Integer getTotalCount() { return totalCount; }
    public void setTotalCount(Integer totalCount) { this.totalCount = totalCount; }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() { return additionalProperties; }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
