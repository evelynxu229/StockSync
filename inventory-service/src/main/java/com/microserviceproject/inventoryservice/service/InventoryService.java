package com.microserviceproject.inventoryservice.service;


import com.microserviceproject.inventoryservice.dto.InventoryResponse;
import com.microserviceproject.inventoryservice.model.Inventory;
import com.microserviceproject.inventoryservice.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInstock(List<String> skuCode){
        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventory ->
                    InventoryResponse.builder()
                            .skuCode(inventory.getSkuCode())
                            .isInstock(inventory.getQuantity() > 0)
                            .build()
                ).toList();
    }


}
