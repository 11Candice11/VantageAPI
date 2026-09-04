package com.vantage.elitewealth.controller;

import com.vantage.elitewealth.model.request.BankAccountRequest;
import com.vantage.elitewealth.service.EntityBankAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/entities/{entityId}/bank-accounts")
public class EntityBankAccountController {

    private final EntityBankAccountService entityBankAccountService;

    public EntityBankAccountController(EntityBankAccountService entityBankAccountService) {
        this.entityBankAccountService = entityBankAccountService;
    }

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAll(@PathVariable Long entityId) {
        return ResponseEntity.ok(entityBankAccountService.getBankAccounts(entityId));
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(
            @PathVariable Long entityId,
            @RequestBody BankAccountRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(entityBankAccountService.createBankAccount(entityId, request));
    }

    @GetMapping("/{bankAccountId}")
    public ResponseEntity<Map<String, Object>> getOne(
            @PathVariable Long entityId,
            @PathVariable Long bankAccountId) {
        return ResponseEntity.ok(entityBankAccountService.getBankAccount(entityId, bankAccountId));
    }

    @DeleteMapping("/{bankAccountId}")
    public ResponseEntity<Void> delete(
            @PathVariable Long entityId,
            @PathVariable Long bankAccountId) {
        entityBankAccountService.deleteBankAccount(entityId, bankAccountId);
        return ResponseEntity.noContent().build();
    }
}
