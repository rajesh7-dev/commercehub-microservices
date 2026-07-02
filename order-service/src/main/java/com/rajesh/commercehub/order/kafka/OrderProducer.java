package com.rajesh.commercehub.order.kafka;

import com.rajesh.commercehub.order.dto.OrderEvent;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderProducer {

    private final KafkaTemplate<String , OrderEvent> kafkaTemplate;

    public void sendOrderEvent(OrderEvent event){

        kafkaTemplate.send("order-topic", event);

        System.out.println("Message sent to Kafka for Order ID : " +event.getOrderId());

    }

}
