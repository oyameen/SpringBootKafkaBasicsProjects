package com.oyameen.stockservice.kafka;



import com.oyameen.commonservice.modle.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderConsumer {

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    private void consume(OrderEvent orderEvent) {
        log.info(String.format("Order event message received from stock service = [ %s", orderEvent.toString() + " ]."));
    }

}
