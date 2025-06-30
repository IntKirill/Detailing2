package ru.kirill.test.orders.service;

import ru.kirill.test.orders.OrderDto.OrderDto;
import ru.kirill.test.orders.model.Order;
import ru.kirill.test.orders.model.Status;

import java.util.List;

public interface OrderService {

    public OrderDto createOrder(OrderDto order);

    public  OrderDto updateOrderStatus(Status status, Long id);

    public Order deleteOrder(Long id);

    public List<OrderDto> getAllOrders ();

    public List<OrderDto> getFilterStatus(Status status);



 }
