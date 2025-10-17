package com.foursale.testetecnico.victor.ms_pedido.boundary.async;

import com.foursale.testetecnico.victor.ms_pedido.boundary.async.body.EventoPagmentoBody;
import com.foursale.testetecnico.victor.ms_pedido.core.application.port.EnviarMensagemPagamento;
import com.foursale.testetecnico.victor.ms_pedido.core.model.OperacaoPagamento;
import com.foursale.testetecnico.victor.ms_pedido.core.model.Pedido;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EventoPagamentoRealizadoKfaka implements EnviarMensagemPagamento {

    @Value("${async.pagamento.topico}")
    private String eventoPagamentoTopico;

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void enviar(Pedido pedido, OperacaoPagamento operacaoPagamento) {
        EventoPagmentoBody body = new EventoPagmentoBody(
                pedido.getId(),
                pedido.calcularTotal(),
                LocalDateTime.now()
        );
        kafkaTemplate.send(eventoPagamentoTopico, new Gson().toJson(body));
    }
}
