package com.microserviceproject.inventoryservice.controller;

import com.microserviceproject.inventoryservice.dto.InventoryResponse;
import com.microserviceproject.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {


    private final InventoryService inventoryService;

    //http://localhost:8082/api/inventory?skuCode=iphone-13&skuCode=iphone13-red
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInstock(@RequestParam List<String> skuCode){

        return inventoryService.isInstock(skuCode);


    }
}
