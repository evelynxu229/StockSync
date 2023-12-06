package com.microserviceproject.inventoryservice.service;


import com.microserviceproject.inventoryservice.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public boolean isInstock(String skuCode){
        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }


}
