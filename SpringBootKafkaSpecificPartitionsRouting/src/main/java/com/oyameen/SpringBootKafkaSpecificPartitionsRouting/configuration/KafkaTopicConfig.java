package com.oyameen.SpringBootKafkaSpecificPartitionsRouting.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.name.string-msg}")
    private String topicName;

    @Value(("${spring.kafka.topic.number.of.partition}"))
    private int numberOfPartition;

    @Bean
    public NewTopic creationOfKafkaTopic() {
        return TopicBuilder.name(topicName)
                .partitions(numberOfPartition) // to specify how much partition for the topic.
                .replicas(1) // to specify how much replica for the topic.
                .build();
    }

}
