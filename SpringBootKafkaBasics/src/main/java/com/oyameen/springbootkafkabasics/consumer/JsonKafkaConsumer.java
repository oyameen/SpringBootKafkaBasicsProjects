package com.oyameen.springbootkafkabasics.consumer;

import com.oyameen.springbootkafkabasics.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JsonKafkaConsumer {

    @KafkaListener(topics = "${spring.kafka.topic.name.json-msg}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(Student student) {
        log.info(String.format("Json message received = [ %s", student.toString() + " ]."));
    }

}
