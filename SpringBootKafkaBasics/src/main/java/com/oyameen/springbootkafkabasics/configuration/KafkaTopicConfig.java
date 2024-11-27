package com.oyameen.springbootkafkabasics.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.name.string-msg}")
    private String stringTopicName;

    @Value("${spring.kafka.topic.name.json-msg}")
    private String jsonTopicName;

    @Bean
    public NewTopic tutorial1KafkaTopic() {
        return TopicBuilder.name(stringTopicName)
                .build();
    }

    @Bean
    public NewTopic tutorial1KafkaJsonTopic() {
        return TopicBuilder.name(jsonTopicName)
                .build();
    }

}
