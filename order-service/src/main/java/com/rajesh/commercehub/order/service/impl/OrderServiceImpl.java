package com.rajesh.commercehub.order.service.impl;

import com.rajesh.commercehub.order.client.ProductClient;
import com.rajesh.commercehub.order.dto.OrderEvent;
import com.rajesh.commercehub.order.dto.Product;
import com.rajesh.commercehub.order.entity.Order;
import com.rajesh.commercehub.order.kafka.OrderProducer;
import com.rajesh.commercehub.order.repository.OrderRepository;
import com.rajesh.commercehub.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {


    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    private final OrderRepository orderRepository;

    private final ProductClient productClient;

    private final OrderProducer orderProducer;

    @Override
    public Order placeOrder(Order order) {

        log.info("[Order] Received order request");

        //CALL PRODUCT SERVICE
        Product product = productClient.getProductById(order.getProductId());

        log.info("[Order] Calling Product Service for product id={}", order.getProductId());

        //VALIDATION
        if(product == null){
            log.error("[Order] Product not found");
            throw new RuntimeException("Product not Found");
        }

        log.info("[Order] Validating stock");

        if(product.getQuantity() < order.getQuantity()){
            log.error("[Order] Insufficient stock");
            throw new RuntimeException("Insufficient stock");
        }

        order.setTotalPrice(product.getPrice() * order.getQuantity());

        log.info("[Order] Saving order");

        Order savedOrder =  orderRepository.save(order);

        OrderEvent event = new OrderEvent(
                savedOrder.getId(), "Order Created Successfully");

        //Sending to Kafka
        orderProducer.sendOrderEvent(event);

       return savedOrder;

    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }


}
