package com.example.coffeeorders.repository;

import com.example.coffeeorders.model.OrderEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderEventRepository extends JpaRepository<OrderEvent, Long> {

    @Query("select count(id) from OrderEvent where orderId= :orderId and eventType=0 or eventType=-1")
    int eventNotCancelledAndReg(@Param("orderId") Long orderId);
}
