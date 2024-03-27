package com.example.coffeeorders.model;

import lombok.Data;
import java.util.List;

@Data
public class Order {
    private Integer orderId;
    private Integer currentEvent;
    private List<OrderEvent> orderEvents;
}
