package com.example.coffeeorders.model;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EventData {
    private Integer stuffId;
    @Expose
    private LocalDate expectedTime;
    @Expose
    private Integer goodId;
    @Expose
    private Integer price;
    @Expose
    private String cancelReason;
    private Integer currentEvent;
}
