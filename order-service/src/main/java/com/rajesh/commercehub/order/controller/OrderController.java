package com.rajesh.commercehub.order.controller;

import com.rajesh.commercehub.order.entity.Order;
import com.rajesh.commercehub.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @PostMapping
    public Order placeOrder(@RequestBody Order order){
        return orderService.placeOrder(order);
    }


}
