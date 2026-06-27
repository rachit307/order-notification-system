package com.rachit.notification_service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @KafkaListener(topics = "order-events", groupId = "notification-group")
    public void consumeOrder(String message) {
        System.out.println("Notification received: " + message);
    }
}