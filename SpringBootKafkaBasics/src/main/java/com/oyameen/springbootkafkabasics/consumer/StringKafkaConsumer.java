package com.oyameen.springbootkafkabasics.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StringKafkaConsumer {

    @KafkaListener(topics = "${spring.kafka.topic.name.string-msg}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) {
        log.info(String.format("String message received = [ %s", message + " ]."));
    }
}
