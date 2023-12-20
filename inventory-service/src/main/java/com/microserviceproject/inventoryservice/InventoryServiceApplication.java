package com.microserviceproject.inventoryservice;

import com.microserviceproject.inventoryservice.model.Inventory;
import com.microserviceproject.inventoryservice.repository.InventoryRepository;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class InventoryServiceApplication {


	private EurekaClient discoveryClient;

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setSkuCode("iphone_13");
			inventory.setQuantity(100);

			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("iphone_13_red");
			inventory1.setQuantity(99);

			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
		};

	}
}
