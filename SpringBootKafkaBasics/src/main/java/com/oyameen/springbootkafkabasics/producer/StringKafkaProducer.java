package com.oyameen.springbootkafkabasics.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StringKafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Value("${spring.kafka.topic.name.string-msg}")
    private String stringTopicName;


    public void sendMessage(String message) {
        log.info(String.format("String message sent = [ %s", message + " ]."));
        kafkaTemplate.send(stringTopicName, message);
    }
}
