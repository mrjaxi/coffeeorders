package com.example.coffeeorders.service;

import com.example.coffeeorders.model.EventData;
import com.example.coffeeorders.model.Order;
import com.example.coffeeorders.model.OrderEvent;
import com.example.coffeeorders.repository.OrderEventRepository;
import com.example.coffeeorders.utils.EventTypes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrdersServiceImpl implements OrderService {

    private final OrderEventRepository eventRepository;

    @Override
    public void publishEvent(OrderEvent event) {
        if (eventRepository.existsById(event.getOrderId())) {
            if (eventRepository.existsEventCancelOrFinish(event.getOrderId()) == 0) {
                if (event.getEventType() - 1 == eventRepository.getLastEventById(event.getOrderId())) {
                    eventRepository.save(event);
                } else if (event.getEventType() == EventTypes.CANCEL.getType()) {
                    eventRepository.save(event);
                }
            }
        } else if (event.getEventType() == EventTypes.REGISTER.getType()) {
            eventRepository.save(event);
        }
    }

    @Override
    public Order findOrder(int id) {
        return null;
    }
}
