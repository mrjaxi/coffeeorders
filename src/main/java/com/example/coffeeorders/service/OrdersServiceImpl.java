package com.example.coffeeorders.service;

import com.example.coffeeorders.model.Order;
import com.example.coffeeorders.model.OrderEvent;
import com.example.coffeeorders.repository.OrderEventRepository;
import com.example.coffeeorders.utils.EventTypes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class OrdersServiceImpl implements OrderService {

    private final OrderEventRepository eventRepository;
    @Override
    public void publishEvent(OrderEvent event) {
        LocalDateTime instance = LocalDateTime.now();
        event.setCreateTime(instance);
        if (eventRepository.existsByOrderId(event.getOrderId()) > 0) {
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
        Order unitData = new Order();
        List<OrderEvent> data = eventRepository.findAllByOrderId(id);

        unitData.setOrderId(data.get(0).getOrderId());
        unitData.setCurrentEvent(data.get(data.size() - 1).getEventType());
        unitData.setOrderEvents(data);

        return unitData;
    }
}
