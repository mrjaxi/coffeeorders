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
        // Установка времени создания события
        LocalDateTime instance = LocalDateTime.now();
        event.setCreateTime(instance);

        // Проверяем существует ли уже Event
        if (eventRepository.existsByOrderId(event.getOrderId()) > 0) {

            // Проверка на то завершен он или отменен
            if (eventRepository.existsEventCancelOrFinish(event.getOrderId()) == 0) {

                // Теперь проверяем тип события и нету ли разырва между ними в типах
                if (event.getEventType() - 1 == eventRepository.getLastEventById(event.getOrderId())) {
                    eventRepository.save(event);

                    // Также если есть разрыв, то проверяем не событие ли отмены пришло
                } else if (event.getEventType() == EventTypes.CANCEL.getType()) {
                    eventRepository.save(event);
                }
            }

            // Если Event не существует, то добавляем новый
        } else if (event.getEventType() == EventTypes.REGISTER.getType()) {
            eventRepository.save(event);
        }
    }

    @Override
    public Order findOrder(int id) {
        // Создаем объект для агрегации данных
        Order unitData = new Order();

        // Получаем все события по OrderID
        List<OrderEvent> data = eventRepository.findAllByOrderId(id);

        // Устанавливаем для выдачи OrderID
        unitData.setOrderId(data.get(0).getOrderId());

        // И устанавливаем текущий тип события на основании последнего события в БД
        unitData.setCurrentEvent(data.get(data.size() - 1).getEventType());

        // Задаем все события по этому OrderID
        unitData.setOrderEvents(data);

        return unitData;
    }
}
