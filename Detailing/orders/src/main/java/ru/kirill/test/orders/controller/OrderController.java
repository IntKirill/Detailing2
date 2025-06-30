package ru.kirill.test.orders.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kirill.test.orders.OrderDto.OrderDto;
import ru.kirill.test.orders.model.Status;
import ru.kirill.test.orders.service.OrderService;


import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/orders")
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping(value = "/create")
    public ResponseEntity <OrderDto>  creatOrder(@RequestBody OrderDto order){
    OrderDto orderDto = orderService.createOrder(order);
    return new ResponseEntity<>(orderDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<OrderDto> updateStatus (@PathVariable Long id, @RequestParam Status status){
        OrderDto orderDto = orderService.updateOrderStatus(status,id);
        return  new ResponseEntity<>(orderDto, HttpStatus.OK);

    }

    @GetMapping
    public List<OrderDto> getOrders (){
        return orderService.getAllOrders();
    }

    @GetMapping("/status")
    public List<OrderDto> getFilterStatus(@RequestParam Status status){
        return orderService.getFilterStatus(status);
    }
}
