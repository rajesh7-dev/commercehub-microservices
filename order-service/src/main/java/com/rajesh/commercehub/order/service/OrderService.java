package com.rajesh.commercehub.order.service;

import com.rajesh.commercehub.order.entity.Order;

import java.util.List;

public interface OrderService {

    Order placeOrder(Order order);

    List<Order> getAllOrders();
}
