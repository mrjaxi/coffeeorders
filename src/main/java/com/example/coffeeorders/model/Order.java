package com.example.coffeeorders.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private Long orderId;
//    private Integer eventType;
//    private LocalDate expectedTime;
//    private Integer goodId;
//    private Integer price;
    private LocalDate date;
}
