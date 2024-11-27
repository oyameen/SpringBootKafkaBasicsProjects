package com.oyameen.SpringBootKafkaSpecificPartitionsRouting.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StringKafkaConsumer {

    @KafkaListener(topics = "${spring.kafka.topic.name.string-msg}", groupId = "${spring.kafka.consumer.group-id}",

            // to consume from specific partition
            topicPartitions = {@TopicPartition(topic = "${spring.kafka.topic.name.string-msg}", partitions = {"3"})})
    public void consume(String message) {
        log.info("String message received = [ {} ].", message);
    }
}
