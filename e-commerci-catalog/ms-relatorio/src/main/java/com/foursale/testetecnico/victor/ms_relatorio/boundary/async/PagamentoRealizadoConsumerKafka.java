package com.foursale.testetecnico.victor.ms_relatorio.boundary.async;

import com.foursale.testetecnico.victor.ms_relatorio.boundary.async.body.PagamentoRealizadoBody;
import com.foursale.testetecnico.victor.ms_relatorio.boundary.service.PagamentoRealizadoService;
import com.foursale.testetecnico.victor.ms_relatorio.core.model.PedidoRelatorio;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PagamentoRealizadoConsumerKafka {

    private final PagamentoRealizadoService pagamentoRealizadoService;

    @KafkaListener(topics = "pagamento-realizado", groupId = "pagamento-realizado-group-1")
    public void receber(String message) {
        log.info("Processamento pagamento realizado");
        PagamentoRealizadoBody body = new Gson().fromJson(message, PagamentoRealizadoBody.class);
        PedidoRelatorio pedidoRelatorio = body.toModel();
        pagamentoRealizadoService.criarPedidoPago(pedidoRelatorio);
    }
}
