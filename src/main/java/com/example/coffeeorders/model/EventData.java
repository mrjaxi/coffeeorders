package com.example.coffeeorders.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EventData {
    private Integer stuffId;
    private String cancelReason;
}
