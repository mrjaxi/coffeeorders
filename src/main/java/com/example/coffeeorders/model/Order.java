package com.example.coffeeorders.model;

import lombok.Data;
import java.util.List;

/*
 Агрегат Order, который будет отдаваться пользователям на основе
 данных из списка объектов OrderEvent
 */

@Data
public class Order {
    private Integer orderId;
    private Integer currentEvent;
    private List<OrderEvent> orderEvents;
}
