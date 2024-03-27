package com.example.coffeeorders.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Order {
    private Integer orderId;
    private Integer stuffId;
    private LocalDate expectedTime;
    private Integer goodId;
    private Integer price;
    private String cancelReason;
    private Integer currentEvent;
    private List<OrderEvent> orderEvents;
}
