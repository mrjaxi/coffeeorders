package com.example.coffeeorders.controller;

import com.example.coffeeorders.model.OrderEvent;
import com.example.coffeeorders.service.OrdersServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1")
@AllArgsConstructor
public class CreateEventController {

    private final OrdersServiceImpl service;

    @GetMapping("/create-event")
    public void createEvent(@RequestBody OrderEvent orderEvent) {
        service.publishEvent(orderEvent);
    }
}
