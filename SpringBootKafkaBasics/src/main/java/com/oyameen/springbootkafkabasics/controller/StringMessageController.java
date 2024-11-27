package com.oyameen.springbootkafkabasics.controller;

import com.oyameen.springbootkafkabasics.producer.StringKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringMessageController {
    @Autowired
    private StringKafkaProducer stringKafkaProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        stringKafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Sending string message to kafka topic done successfully.");
    }

}
