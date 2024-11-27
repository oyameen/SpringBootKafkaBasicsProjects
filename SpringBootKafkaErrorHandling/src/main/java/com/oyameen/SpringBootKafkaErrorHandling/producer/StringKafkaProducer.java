package com.oyameen.SpringBootKafkaErrorHandling.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class StringKafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Value("${spring.kafka.topic.name.string-msg}")
    private String topicName;

    public void sendMessage(String message) {
        CompletableFuture<SendResult<String, String>> completableFuture = kafkaTemplate.send(topicName, message);
        completableFuture.whenComplete((result, exception) -> {
            if (exception != null) {
                log.error("Not able to send the message = [ {} ], due to exception = [ {} ].", message, exception.getMessage());
            } else {
                log.info("String message sent = [ {} ], with partition = [ {} ] and offset = [ {} ].", message, result.getRecordMetadata().partition(), result.getRecordMetadata().offset());
            }
        });
    }
}
