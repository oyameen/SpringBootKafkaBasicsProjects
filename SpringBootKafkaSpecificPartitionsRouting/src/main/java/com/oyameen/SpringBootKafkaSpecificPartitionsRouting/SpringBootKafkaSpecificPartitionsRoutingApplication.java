package com.oyameen.SpringBootKafkaSpecificPartitionsRouting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class SpringBootKafkaSpecificPartitionsRoutingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKafkaSpecificPartitionsRoutingApplication.class, args);
    }

}
