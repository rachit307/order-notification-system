package com.rachit.order_service.controller;

import com.rachit.order_service.kafka.OrderProducer;
import com.rachit.order_service.model.Order;
import com.rachit.order_service.repository.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderProducer orderProducer;
    private final OrderRepository orderRepository;

    public OrderController(OrderProducer orderProducer, OrderRepository orderRepository) {
        this.orderProducer = orderProducer;
        this.orderRepository = orderRepository;
    }

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        Order savedOrder = orderRepository.save(order);
        String message = "Order placed: " + savedOrder.getOrderId() + " for " + savedOrder.getProduct();
        orderProducer.sendOrder(savedOrder.getOrderId(), message);
        return ResponseEntity.ok(savedOrder);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderRepository.findAll());
    }
}