package com.foursale.testetecnico.victor.ms_pagamento.boundary.async;

import com.foursale.testetecnico.victor.ms_pagamento.boundary.async.body.EventoPedigoPagoBody;
import com.foursale.testetecnico.victor.ms_pagamento.core.application.port.EnviarMensagemPedidoPago;
import com.foursale.testetecnico.victor.ms_pagamento.core.model.Pedido;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventoPedidoPagoKafka implements EnviarMensagemPedidoPago {

    @Value("${async.pedido.pago.topico}")
    private String topico;

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void enviar(Pedido pedido) {
        EventoPedigoPagoBody body = new EventoPedigoPagoBody(pedido.getId());
        kafkaTemplate.send(topico, new Gson().toJson(body));
    }
}
