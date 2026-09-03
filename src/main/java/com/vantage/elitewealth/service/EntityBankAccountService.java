package com.vantage.elitewealth.service;

import com.vantage.elitewealth.model.request.BankAccountRequest;

import java.util.List;
import java.util.Map;

public interface EntityBankAccountService {
    List<Map<String, Object>> getBankAccounts(Long entityId);
    Map<String, Object> createBankAccount(Long entityId, BankAccountRequest request);
    Map<String, Object> getBankAccount(Long entityId, Long bankAccountId);
    void deleteBankAccount(Long entityId, Long bankAccountId);
}
