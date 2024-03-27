package com.example.coffeeorders.repository;

import com.example.coffeeorders.model.OrderEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderEventRepository extends JpaRepository<OrderEvent, Integer> {

    @Query("select count(id) from OrderEvent where orderId= :orderId and eventType=4 or eventType=5")
    int existsEventCancelOrFinish(@Param("orderId") int orderId);

    @Query("select eventType from OrderEvent where orderId=:orderId order by eventType desc limit 1")
    int getLastEventById(int orderId);

    @Query("select count(id) from OrderEvent where orderId= :orderId")
    int existsByOrderId(@Param("orderId") int orderId);

    List<OrderEvent> findAllByOrderId(int orderId);
}
