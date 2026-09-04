package com.vantage.elitewealth.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Request body for POST /restApiData/Portfolio/Extract
 * Field names must match the EliteWealth API exactly.
 */
public class PortfolioExtractRequest {

    @JsonProperty("EntityIds")
    private List<String> entityIds;

    @JsonProperty("ValueInputModels")
    private List<ValueInputModel> valueInputModels;

    @JsonProperty("TransactionInputModels")
    private List<TransactionInputModel> transactionInputModels;

    @JsonProperty("AssetExposureInputModels")
    private List<AssetExposureInputModel> assetExposureInputModels;

    public PortfolioExtractRequest() {}

    public List<String> getEntityIds() { return entityIds; }
    public void setEntityIds(List<String> entityIds) { this.entityIds = entityIds; }

    public List<ValueInputModel> getValueInputModels() { return valueInputModels; }
    public void setValueInputModels(List<ValueInputModel> v) { this.valueInputModels = v; }

    public List<TransactionInputModel> getTransactionInputModels() { return transactionInputModels; }
    public void setTransactionInputModels(List<TransactionInputModel> t) { this.transactionInputModels = t; }

    public List<AssetExposureInputModel> getAssetExposureInputModels() { return assetExposureInputModels; }
    public void setAssetExposureInputModels(List<AssetExposureInputModel> a) { this.assetExposureInputModels = a; }

    // ── Nested models (matching real API field names) ─────────────────────

    public static class ValueInputModel {
        @JsonProperty("DateApplicable")
        private String dateApplicable;

        @JsonProperty("ValueTypeL")
        private Integer valueTypeL;

        @JsonProperty("TargetCurrencyL")
        private Integer targetCurrencyL;

        public ValueInputModel() {}

        public ValueInputModel(String dateApplicable, int valueTypeL, int targetCurrencyL) {
            this.dateApplicable = dateApplicable;
            this.valueTypeL     = valueTypeL;
            this.targetCurrencyL = targetCurrencyL;
        }

        public String getDateApplicable()   { return dateApplicable; }
        public Integer getValueTypeL()      { return valueTypeL; }
        public Integer getTargetCurrencyL() { return targetCurrencyL; }
        public void setDateApplicable(String d)  { this.dateApplicable = d; }
        public void setValueTypeL(Integer v)     { this.valueTypeL = v; }
        public void setTargetCurrencyL(Integer c){ this.targetCurrencyL = c; }
    }

    public static class TransactionInputModel {
        @JsonProperty("DateFrom")
        private String dateFrom;

        @JsonProperty("DateTo")
        private String dateTo;

        @JsonProperty("TargetCurrencyL")
        private Integer targetCurrencyL;

        public TransactionInputModel() {}

        public TransactionInputModel(String dateFrom, String dateTo, int targetCurrencyL) {
            this.dateFrom        = dateFrom;
            this.dateTo          = dateTo;
            this.targetCurrencyL = targetCurrencyL;
        }

        public String getDateFrom()         { return dateFrom; }
        public String getDateTo()           { return dateTo; }
        public Integer getTargetCurrencyL() { return targetCurrencyL; }
        public void setDateFrom(String d)        { this.dateFrom = d; }
        public void setDateTo(String d)          { this.dateTo = d; }
        public void setTargetCurrencyL(Integer c){ this.targetCurrencyL = c; }
    }

    public static class AssetExposureInputModel {
        @JsonProperty("DateApplicable")
        private String dateApplicable;

        @JsonProperty("CountryL")
        private Integer countryL;

        @JsonProperty("TargetCurrencyL")
        private Integer targetCurrencyL;

        public AssetExposureInputModel() {}

        public AssetExposureInputModel(String dateApplicable, int countryL, int targetCurrencyL) {
            this.dateApplicable  = dateApplicable;
            this.countryL        = countryL;
            this.targetCurrencyL = targetCurrencyL;
        }

        public String getDateApplicable()   { return dateApplicable; }
        public Integer getCountryL()        { return countryL; }
        public Integer getTargetCurrencyL() { return targetCurrencyL; }
        public void setDateApplicable(String d)  { this.dateApplicable = d; }
        public void setCountryL(Integer c)       { this.countryL = c; }
        public void setTargetCurrencyL(Integer c){ this.targetCurrencyL = c; }
    }
}
