package com.oyameen.SpringBootKafkaErrorHandling.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StringKafkaConsumer {

    //To Handle the error by retry.
    @RetryableTopic(attempts = "4" /* 4-1 = number of topic (3) partition // N-1 = (4-1)*/,
    backoff = @Backoff(delay = 4000 , multiplier = 2, maxDelay = 20000) /*to configure the delay*/)
    @KafkaListener(topics = "${spring.kafka.topic.name.string-msg}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message, @Header(KafkaHeaders.RECEIVED_TOPIC)String topic, @Header(KafkaHeaders.OFFSET) long offset) {
        log.info("String message = [ {} ], from topic = [ {} ], and offset = [ {} ].", message, topic, offset);

        if ("xyz".equals(message))
            throw new RuntimeException("Invalid message.");
    }

    @DltHandler
    public void DLTErrorListener(String message, @Header(KafkaHeaders.RECEIVED_TOPIC)String topic, @Header(KafkaHeaders.OFFSET) long offset)
    {
        log.info("DLT received message = [ {} ], from topic = [ {} ], and offset = [ {} ].", message, topic, offset);
    }
}
