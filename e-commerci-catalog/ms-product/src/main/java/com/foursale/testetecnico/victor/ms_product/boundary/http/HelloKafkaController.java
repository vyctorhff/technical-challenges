package com.foursale.testetecnico.victor.ms_product.boundary.http;

import com.foursale.testetecnico.victor.ms_product.boundary.async.ProdutorKafka;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-kafka")
@RequiredArgsConstructor
public class HelloKafkaController {

    // TODO: remover

    private final ProdutorKafka produtorKafka;

    @GetMapping("/{msg}")
    public ResponseEntity<Void> send(@PathVariable("msg") String msg) {
        produtorKafka.send("Hello kafka");
        return ResponseEntity.ok().build();
    }
}
