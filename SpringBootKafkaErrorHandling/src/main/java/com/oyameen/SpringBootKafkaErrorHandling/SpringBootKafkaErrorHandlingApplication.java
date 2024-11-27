package com.oyameen.SpringBootKafkaErrorHandling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class SpringBootKafkaErrorHandlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKafkaErrorHandlingApplication.class, args);
	}

}
