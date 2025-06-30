package ru.kirill.test.orders.model;

import lombok.Getter;

@Getter
public enum Status {
    GENERATED("Создан"),
    HIRED("Принят в работу") ,
    COMPLETED ("Завершен");

    private final String description;

    Status (String description) {
        this.description = description;
    }
}
