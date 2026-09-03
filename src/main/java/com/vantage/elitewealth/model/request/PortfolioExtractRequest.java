package com.vantage.elitewealth.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PortfolioExtractRequest {

    @JsonProperty("EntityIds")
    private List<Long> entityIds;

    @JsonProperty("ValueInputModels")
    private List<ValueInputModel> valueInputModels;

    @JsonProperty("TransactionInputModels")
    private List<TransactionInputModel> transactionInputModels;

    @JsonProperty("AssetExposureInputModels")
    private List<AssetExposureInputModel> assetExposureInputModels;

    public PortfolioExtractRequest() {}

    public List<Long> getEntityIds() { return entityIds; }
    public void setEntityIds(List<Long> entityIds) { this.entityIds = entityIds; }

    public List<ValueInputModel> getValueInputModels() { return valueInputModels; }
    public void setValueInputModels(List<ValueInputModel> valueInputModels) {
        this.valueInputModels = valueInputModels;
    }

    public List<TransactionInputModel> getTransactionInputModels() { return transactionInputModels; }
    public void setTransactionInputModels(List<TransactionInputModel> transactionInputModels) {
        this.transactionInputModels = transactionInputModels;
    }

    public List<AssetExposureInputModel> getAssetExposureInputModels() { return assetExposureInputModels; }
    public void setAssetExposureInputModels(List<AssetExposureInputModel> assetExposureInputModels) {
        this.assetExposureInputModels = assetExposureInputModels;
    }

    // ── Nested input models ──────────────────────────────────────────────────

    public static class ValueInputModel {
        @JsonProperty("PortfolioId")
        private Long portfolioId;

        @JsonProperty("Date")
        private String date;

        @JsonProperty("CurrencyCode")
        private String currencyCode;

        public Long getPortfolioId() { return portfolioId; }
        public void setPortfolioId(Long portfolioId) { this.portfolioId = portfolioId; }

        public String getDate() { return date; }
        public void setDate(String date) { this.date = date; }

        public String getCurrencyCode() { return currencyCode; }
        public void setCurrencyCode(String currencyCode) { this.currencyCode = currencyCode; }
    }

    public static class TransactionInputModel {
        @JsonProperty("PortfolioId")
        private Long portfolioId;

        @JsonProperty("FromDate")
        private String fromDate;

        @JsonProperty("ToDate")
        private String toDate;

        public Long getPortfolioId() { return portfolioId; }
        public void setPortfolioId(Long portfolioId) { this.portfolioId = portfolioId; }

        public String getFromDate() { return fromDate; }
        public void setFromDate(String fromDate) { this.fromDate = fromDate; }

        public String getToDate() { return toDate; }
        public void setToDate(String toDate) { this.toDate = toDate; }
    }

    public static class AssetExposureInputModel {
        @JsonProperty("PortfolioId")
        private Long portfolioId;

        @JsonProperty("Date")
        private String date;

        public Long getPortfolioId() { return portfolioId; }
        public void setPortfolioId(Long portfolioId) { this.portfolioId = portfolioId; }

        public String getDate() { return date; }
        public void setDate(String date) { this.date = date; }
    }
}
