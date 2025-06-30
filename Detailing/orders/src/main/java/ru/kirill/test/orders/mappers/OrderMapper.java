package ru.kirill.test.orders.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.kirill.test.orders.OrderDto.OrderDto;
import ru.kirill.test.orders.model.Order;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {

    OrderDto toOrderDto(Order order);//Преобразует Order в сущность OrderDto.

    List<OrderDto>toOrderDtoList(List<Order> orderList);

    Order toOrder(OrderDto orderDto); //Преобразует OrderDto в сущность Order.



}
