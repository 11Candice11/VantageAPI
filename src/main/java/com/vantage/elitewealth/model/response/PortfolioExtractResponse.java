package com.vantage.elitewealth.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class PortfolioExtractResponse {

    @JsonProperty("TreeOutputModel")
    private Map<String, Object> treeOutputModel;

    @JsonProperty("ValueOutputModels")
    private List<Map<String, Object>> valueOutputModels;

    @JsonProperty("TransactionOutputModels")
    private List<Map<String, Object>> transactionOutputModels;

    public PortfolioExtractResponse() {}

    public Map<String, Object> getTreeOutputModel() { return treeOutputModel; }
    public void setTreeOutputModel(Map<String, Object> treeOutputModel) {
        this.treeOutputModel = treeOutputModel;
    }

    public List<Map<String, Object>> getValueOutputModels() { return valueOutputModels; }
    public void setValueOutputModels(List<Map<String, Object>> valueOutputModels) {
        this.valueOutputModels = valueOutputModels;
    }

    public List<Map<String, Object>> getTransactionOutputModels() { return transactionOutputModels; }
    public void setTransactionOutputModels(List<Map<String, Object>> transactionOutputModels) {
        this.transactionOutputModels = transactionOutputModels;
    }
}
