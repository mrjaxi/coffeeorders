package com.example.coffeeorders.service;

import com.example.coffeeorders.model.EventData;
import com.example.coffeeorders.model.Order;
import com.example.coffeeorders.model.OrderEvent;
import com.example.coffeeorders.repository.OrderEventRepository;
import com.example.coffeeorders.repository.OrdersRepository;
import com.example.coffeeorders.utils.EventTypes;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrdersServiceImpl implements OrderService {

    private final OrderEventRepository eventRepository;
    private final OrdersRepository ordersRepository;

    @Override
    public void publishEvent(OrderEvent event) {
        // REGISTER EVENT
        if (ordersRepository.getEventTypeByOrderId(event.getOrderId()) != EventTypes.CANCEL.getType()) {
            eventRepository.save(event);
        }
//        if (event.getEventType() == EventTypes.REGISTER.getType()) {
//            if (eventRepository.eventNotCancelledAndReg(event.getOrderId()) == 0) {
//                eventRepository.save(event);
//            }
//        }
    }

    @Override
    public Order findOrder(int id) {
        return null;
    }
}
