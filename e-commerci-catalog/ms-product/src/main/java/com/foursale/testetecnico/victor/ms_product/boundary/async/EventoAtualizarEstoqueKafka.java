package com.foursale.testetecnico.victor.ms_product.boundary.async;

import com.foursale.testetecnico.victor.ms_product.boundary.async.body.EventoAtualizarEstoqueBody;
import com.foursale.testetecnico.victor.ms_product.core.application.ports.EnviarMensagemEstoque;
import com.foursale.testetecnico.victor.ms_product.core.model.OperacaoEstoque;
import com.foursale.testetecnico.victor.ms_product.core.model.Produto;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventoAtualizarEstoqueKafka implements EnviarMensagemEstoque {

    @Value("${async.produto.topico}")
    private String topico;

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void enviar(Produto produto, OperacaoEstoque operacao) {
        EventoAtualizarEstoqueBody body = new EventoAtualizarEstoqueBody(produto, operacao);
        kafkaTemplate.send(topico, new Gson().toJson(body));
    }
}
