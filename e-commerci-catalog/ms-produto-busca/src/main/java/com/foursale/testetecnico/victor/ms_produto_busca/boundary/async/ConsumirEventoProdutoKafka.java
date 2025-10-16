package com.foursale.testetecnico.victor.ms_produto_busca.boundary.async;

import com.foursale.testetecnico.victor.ms_produto_busca.boundary.repository.data.ProdutoData;
import com.foursale.testetecnico.victor.ms_produto_busca.boundary.service.CriarProdutoService;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsumirEventoProdutoKafka {

    private final CriarProdutoService service;

    @KafkaListener(topics = "produto-alteracao", groupId = "hello-group-1")
    public void reciveHello(String message) {
        ProdutoData data = new Gson().fromJson(message, ProdutoData.class);
        this.service.criar(data.toModel());
    }
}
