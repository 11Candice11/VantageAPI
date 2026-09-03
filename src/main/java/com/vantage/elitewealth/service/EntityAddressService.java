package com.vantage.elitewealth.service;

import com.vantage.elitewealth.model.request.AddressRequest;

import java.util.List;
import java.util.Map;

public interface EntityAddressService {
    List<Map<String, Object>> getAddresses(Long addressEntityId);
    Map<String, Object> createAddress(Long addressEntityId, AddressRequest request);
    Map<String, Object> getAddress(Long entityId, Long addressId);
    void deleteAddress(Long entityId, Long addressId);
}
