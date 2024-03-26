package com.example.coffeeorders.repository;

import com.example.coffeeorders.model.OrderEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderEventRepository extends JpaRepository<OrderEvent, Long> {

    @Query("select count(id) from OrderEvent where orderId= :orderId and eventType=4 or eventType=5")
    int existsEventCancelOrFinish(@Param("orderId") Long orderId);

    @Query("select eventType from OrderEvent where orderId=:orderId order by eventType desc limit 1")
    int getLastEventById(Long orderId);


}
