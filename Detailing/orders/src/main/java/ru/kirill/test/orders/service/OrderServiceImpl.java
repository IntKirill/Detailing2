package ru.kirill.test.orders.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kirill.test.orders.OrderDto.OrderDto;
import ru.kirill.test.orders.mappers.OrderMapper;
import ru.kirill.test.orders.model.Order;
import ru.kirill.test.orders.model.Status;
import ru.kirill.test.orders.repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;


    @Override
    public OrderDto createOrder(OrderDto order) {
        Order orders = new Order();
        orders.setName(order.getName());
        orders.setModelCar(order.getModelCar());
        orders.setServiceType(order.getServiceType());
        orders.setStatus(Status.GENERATED);
        orders.setCreateAt(LocalDateTime.now());
        Order saveOrder = orderRepository.save(orders);
       return orderMapper.toOrderDto(saveOrder);
    }

    @Override
    public OrderDto updateOrderStatus(Status status, Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Заказ, который вы хотите изменить не был создан или удален"));
     order.setStatus(status);
     order.setUpdatedAt(LocalDateTime.now());
     return orderMapper.toOrderDto(order);
    }

    @Override
    public Order deleteOrder(Long id ) {
       Order order = orderRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Заказ, который вы хотите удалить не существует или уже был удален"));
       orderRepository.delete(order);
       return order;
    }

    @Override
    public List<OrderDto> getFilterStatus(Status status) {
        List<Order> orderList = orderRepository.findByStatus(status);
        return orderMapper.toOrderDtoList(orderList);
        }


    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orderList = orderRepository.findAll();
        return orderMapper.toOrderDtoList(orderList);

    }
}
