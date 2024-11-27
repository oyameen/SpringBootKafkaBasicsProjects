package com.oyameen.orderservice.controller;





import com.oyameen.commonservice.modle.Order;
import com.oyameen.commonservice.modle.OrderEvent;
import com.oyameen.commonservice.modle.OrderEventStatus;
import com.oyameen.orderservice.kafka.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class OrderController {
    @Autowired
    private OrderProducer orderProducer;

    @PostMapping("/orders")
    public ResponseEntity<String> addOrder(@RequestBody Order order) {
        order.setId(UUID.randomUUID().toString());
        OrderEvent orderEvent = new OrderEvent(order, "order still in pending state", OrderEventStatus.PENDING);
        orderProducer.sendMessage(orderEvent);
        return ResponseEntity.ok("Adding order to kafka topic done successfully.");
    }
}
