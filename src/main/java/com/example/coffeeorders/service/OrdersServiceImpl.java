package com.example.coffeeorders.service;

import com.example.coffeeorders.model.EventData;
import com.example.coffeeorders.model.Order;
import com.example.coffeeorders.model.OrderEvent;
import com.example.coffeeorders.repository.OrderEventRepository;
import com.example.coffeeorders.utils.EventTypes;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Order agregat = new Order();
        List<OrderEvent> data = eventRepository.findAllByOrderId(id);

//        EventData eventData =
//        agregat.setPrice(eventData.getPrice());
        agregat.setOrderEvents(data);
//        agregat.setOrderId(data.get(0).getOrderId());
//        agregat.setOrderEvents(data);
        // TODO: нужно как-то реализовать выборку данных из базы данных по OrderEvent и все скомпоновать
        return agregat;
    }
}
