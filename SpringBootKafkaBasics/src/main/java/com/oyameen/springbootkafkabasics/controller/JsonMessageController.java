package com.oyameen.springbootkafkabasics.controller;

import com.oyameen.springbootkafkabasics.producer.JsonKafkaProducer;
import com.oyameen.springbootkafkabasics.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonMessageController {
    @Autowired
    private JsonKafkaProducer jsonKafkaProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody Student student) {
        jsonKafkaProducer.sendMessage(student);
        return ResponseEntity.ok("Sending json message to kafka topic done successfully.");
    }
}
