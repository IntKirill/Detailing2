package ru.kirill.test.orders.OrderDto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import ru.kirill.test.orders.model.ServiceType;
import ru.kirill.test.orders.model.Status;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderDto {

    private Long id;

    private String name;

    private String modelCar;

    private ServiceType serviceType;

    private Status status;

    private LocalDateTime createAt;
}
