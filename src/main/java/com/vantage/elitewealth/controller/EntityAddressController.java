package com.vantage.elitewealth.controller;

import com.vantage.elitewealth.model.request.AddressRequest;
import com.vantage.elitewealth.service.EntityAddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/entities/{entityId}/addresses")
public class EntityAddressController {

    private final EntityAddressService entityAddressService;

    public EntityAddressController(EntityAddressService entityAddressService) {
        this.entityAddressService = entityAddressService;
    }

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAll(@PathVariable Long entityId) {
        return ResponseEntity.ok(entityAddressService.getAddresses(entityId));
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(
            @PathVariable Long entityId,
            @RequestBody AddressRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(entityAddressService.createAddress(entityId, request));
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<Map<String, Object>> getOne(
            @PathVariable Long entityId,
            @PathVariable Long addressId) {
        return ResponseEntity.ok(entityAddressService.getAddress(entityId, addressId));
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<Void> delete(
            @PathVariable Long entityId,
            @PathVariable Long addressId) {
        entityAddressService.deleteAddress(entityId, addressId);
        return ResponseEntity.noContent().build();
    }
}
