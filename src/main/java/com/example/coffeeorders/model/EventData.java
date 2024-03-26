package com.example.coffeeorders.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EventData {
    private Integer stuffId;
    private LocalDate expectedTime;
    private Integer goodId;
    private String cancelReason;
    private Integer price;
}
