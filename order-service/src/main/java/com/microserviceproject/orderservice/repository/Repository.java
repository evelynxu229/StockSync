package com.microserviceproject.orderservice.repository;

import com.microserviceproject.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Order, Long> {
}
