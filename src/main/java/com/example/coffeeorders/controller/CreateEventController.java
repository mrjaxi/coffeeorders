package com.example.coffeeorders.controller;

import com.example.coffeeorders.model.Order;
import com.example.coffeeorders.model.OrderEvent;
import com.example.coffeeorders.service.OrderService;
import com.example.coffeeorders.service.OrdersServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class CreateEventController {

    private final OrdersServiceImpl service;

    @PostMapping("/create-event")
    public void createEvent(@RequestBody OrderEvent orderEvent) {
        service.publishEvent(orderEvent);
    }

    @GetMapping("/get-event/{id}")
    public Order getEvent(@PathVariable int id) {
        return service.findOrder(id);
    }
}
