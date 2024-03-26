package com.example.coffeeorders.model;

import com.example.coffeeorders.utils.ConverterData;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "order_event")
public class OrderEvent {
    @Id
    @GeneratedValue
    private Long id;
    private Long orderId;
//    @Embedded
    @Convert(converter = ConverterData.class)
    @Column(columnDefinition = "json")
    private Object data;
    private Integer eventType;
    private LocalDate createTime;
}