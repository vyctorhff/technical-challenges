package com.foursale.testetecnico.victor.ms_product.boundary.async;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumidorKafka {
    // TODO: remover
    @KafkaListener(topics = "hello-topic", groupId = "hello-group-1")
    public void reciveHello(String message) {
        System.out.println("Consumer: " + message);
    }
}
