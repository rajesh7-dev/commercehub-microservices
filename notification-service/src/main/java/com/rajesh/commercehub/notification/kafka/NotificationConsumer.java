package com.rajesh.commercehub.notification.kafka;

import com.rajesh.commercehub.notification.dto.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @KafkaListener(topics = "order-topic", groupId = "notification-group")
    public void consume(OrderEvent event){

        System.out.println("Email Sent Successfully for Order ID :" +event.getOrderId());
    }

}
