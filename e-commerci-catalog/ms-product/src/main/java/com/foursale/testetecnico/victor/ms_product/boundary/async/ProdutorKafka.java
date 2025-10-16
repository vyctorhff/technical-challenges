package com.foursale.testetecnico.victor.ms_product.boundary.async;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutorKafka {
    // TODO: remover
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(String message) {
        kafkaTemplate.send("hello-topic", message);
    }
}
