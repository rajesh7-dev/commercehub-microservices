package com.rajesh.commercehub.order.service.impl;

import com.rajesh.commercehub.order.client.ProductClient;
import com.rajesh.commercehub.order.dto.Product;
import com.rajesh.commercehub.order.entity.Order;
import com.rajesh.commercehub.order.repository.OrderRepository;
import com.rajesh.commercehub.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final ProductClient productClient;

    @Override
    public Order placeOrder(Order order) {

        //CALL PRODUCT SERVICE
        Product product = productClient.getProductById(order.getProductId());

        //VALIDATION
        if(product == null){
            throw new RuntimeException("Product not Found");
        }

        if(product.getQuantity() < order.getQuantity()){
            throw new RuntimeException("Insufficient stock");
        }

        order.setTotalPrice(product.getPrice() * order.getQuantity());

        return orderRepository.save(order);

    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }


}
