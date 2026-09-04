package com.vantage.elitewealth.service.impl;

import com.vantage.elitewealth.client.EntityBankAccountClient;
import com.vantage.elitewealth.model.request.BankAccountRequest;
import com.vantage.elitewealth.service.EntityBankAccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EntityBankAccountServiceImpl implements EntityBankAccountService {

    private final EntityBankAccountClient entityBankAccountClient;

    public EntityBankAccountServiceImpl(EntityBankAccountClient entityBankAccountClient) {
        this.entityBankAccountClient = entityBankAccountClient;
    }

    @Override
    public List<Map<String, Object>> getBankAccounts(Long entityId) {
        return entityBankAccountClient.getBankAccounts(entityId);
    }

    @Override
    public Map<String, Object> createBankAccount(Long entityId, BankAccountRequest request) {
        return entityBankAccountClient.createBankAccount(entityId, request);
    }

    @Override
    public Map<String, Object> getBankAccount(Long entityId, Long bankAccountId) {
        return entityBankAccountClient.getBankAccount(entityId, bankAccountId);
    }

    @Override
    public void deleteBankAccount(Long entityId, Long bankAccountId) {
        entityBankAccountClient.deleteBankAccount(entityId, bankAccountId);
    }
}
