package ru.kirill.test.orders.model;

import lombok.Getter;

@Getter
public enum ServiceType {

    DryCleaning("ХимЧистка"),
    Washing("Мойка"),
    Polishing("Полировка"),
    Ceramics("Керамика"),
    AntiRain("АнтиДождь");

    private final String description;

    ServiceType(String description) {
        this.description = description;
    }
}
