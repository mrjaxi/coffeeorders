package com.example.coffeeorders.service;

import com.example.coffeeorders.model.Order;
import com.example.coffeeorders.model.OrderEvent;
import com.example.coffeeorders.repository.OrderEventRepository;
import com.example.coffeeorders.repository.OrdersRepository;
import com.example.coffeeorders.utils.EventTypes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.InvalidMarkException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrdersServiceImpl implements OrderService {

    private final OrderEventRepository eventRepository;
    private final OrdersRepository ordersRepository;

    @Override
    public void publishEvent(OrderEvent event) {
        // Проверка есть ли вообще order с таким id, по которому мы хотим добавить событие
        if (ordersRepository.existsById(event.getOrderId())) {

            // Проверка нету ли завершенных событий или отмененных
            if (eventRepository.existsEventCancelOrFinish(event.getOrderId()) == 0) {

                eventRepository.save(event);
            }
        }
    }

    @Override
    public Order findOrder(int id) {
        return null;
    }
}
