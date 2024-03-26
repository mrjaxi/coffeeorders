package com.example.coffeeorders.repository;

import com.example.coffeeorders.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrdersRepository extends JpaRepository<Order, Long> {
    boolean existsById(Long id);

    Order findByOrderId();
}
