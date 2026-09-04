package com.vantage.elitewealth.service.impl;

import com.vantage.elitewealth.client.EntityAddressClient;
import com.vantage.elitewealth.model.request.AddressRequest;
import com.vantage.elitewealth.service.EntityAddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EntityAddressServiceImpl implements EntityAddressService {

    private final EntityAddressClient entityAddressClient;

    public EntityAddressServiceImpl(EntityAddressClient entityAddressClient) {
        this.entityAddressClient = entityAddressClient;
    }

    @Override
    public List<Map<String, Object>> getAddresses(Long addressEntityId) {
        return entityAddressClient.getAddresses(addressEntityId);
    }

    @Override
    public Map<String, Object> createAddress(Long addressEntityId, AddressRequest request) {
        return entityAddressClient.createAddress(addressEntityId, request);
    }

    @Override
    public Map<String, Object> getAddress(Long entityId, Long addressId) {
        return entityAddressClient.getAddress(entityId, addressId);
    }

    @Override
    public void deleteAddress(Long entityId, Long addressId) {
        entityAddressClient.deleteAddress(entityId, addressId);
    }
}
