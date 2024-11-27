package com.oyameen.springbootkafkabasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class SpringBootKafkaBasicsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKafkaBasicsApplication.class, args);
    }

}
