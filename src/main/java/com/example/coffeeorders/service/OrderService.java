package com.example.coffeeorders.service;

import com.example.coffeeorders.model.Order;
import com.example.coffeeorders.model.OrderEvent;

public interface OrderService {
    void publishEvent(OrderEvent event);

    Order findOrder(int id);
}
