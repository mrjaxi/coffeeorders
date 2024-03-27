package com.example.coffeeorders.model;

import com.example.coffeeorders.utils.ConverterData;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "order_event")
public class OrderEvent {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer orderId;
//    @Embedded
    @Convert(converter = ConverterData.class)
    @Column(columnDefinition = "json")
    private Object data;
    private Integer eventType;
    private LocalDateTime createTime;
}