package com.vantage.elitewealth.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankAccountRequest {

    @JsonProperty("BankAccountTypeId")
    private Long bankAccountTypeId;

    @JsonProperty("BankName")
    private String bankName;

    @JsonProperty("BranchCode")
    private String branchCode;

    @JsonProperty("AccountNumber")
    private String accountNumber;

    @JsonProperty("AccountHolderName")
    private String accountHolderName;

    @JsonProperty("CurrencyCode")
    private String currencyCode;

    @JsonProperty("IsPrimary")
    private Boolean isPrimary;

    public BankAccountRequest() {}

    public Long getBankAccountTypeId() { return bankAccountTypeId; }
    public void setBankAccountTypeId(Long bankAccountTypeId) { this.bankAccountTypeId = bankAccountTypeId; }

    public String getBankName() { return bankName; }
    public void setBankName(String bankName) { this.bankName = bankName; }

    public String getBranchCode() { return branchCode; }
    public void setBranchCode(String branchCode) { this.branchCode = branchCode; }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public String getAccountHolderName() { return accountHolderName; }
    public void setAccountHolderName(String accountHolderName) { this.accountHolderName = accountHolderName; }

    public String getCurrencyCode() { return currencyCode; }
    public void setCurrencyCode(String currencyCode) { this.currencyCode = currencyCode; }

    public Boolean getIsPrimary() { return isPrimary; }
    public void setIsPrimary(Boolean isPrimary) { this.isPrimary = isPrimary; }
}
