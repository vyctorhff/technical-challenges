package com.foursale.testetecnico.victor.ms_pagamento.boundary.async;

import com.foursale.testetecnico.victor.ms_pagamento.boundary.async.body.PagmentoInicialConsumerBody;
import com.foursale.testetecnico.victor.ms_pagamento.boundary.service.CriarPagamentoService;
import com.foursale.testetecnico.victor.ms_pagamento.core.model.Pagamento;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PagamentoInicialConsumerKafka {

    private final CriarPagamentoService service;

    @KafkaListener(topics = "pagamento-pendente", groupId = "pagamento-group-1")
    public void receber(String message) {
        log.info("Processando abertura de pagamento");

        PagmentoInicialConsumerBody body = new Gson().fromJson(message, PagmentoInicialConsumerBody.class);
        Pagamento pagamento = body.toModel();
        service.criar(pagamento);
    }
}
