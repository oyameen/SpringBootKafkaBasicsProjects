package com.oyameen.springbootkafkabasics.producer;

import com.oyameen.springbootkafkabasics.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JsonKafkaProducer {
    @Autowired
    private KafkaTemplate<String, Student> kafkaTemplate;

    @Value("${spring.kafka.topic.name.json-msg}")
    private String jsonTopicName;


    public void sendMessage(Student student) {
        log.info(String.format("Json message sent = [ %s", student.toString() + " ]."));
        Message<Student> message = MessageBuilder
                .withPayload(student)
                .setHeader(KafkaHeaders.TOPIC, jsonTopicName)
                .build();
        kafkaTemplate.send(message);
    }
}
