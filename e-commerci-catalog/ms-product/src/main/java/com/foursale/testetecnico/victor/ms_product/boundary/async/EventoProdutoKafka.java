package com.foursale.testetecnico.victor.ms_product.boundary.async;

import com.foursale.testetecnico.victor.ms_product.boundary.async.body.EventoProdutoBody;
import com.foursale.testetecnico.victor.ms_product.core.application.ports.EnviarMensagemProduto;
import com.foursale.testetecnico.victor.ms_product.core.model.OperacaoProduto;
import com.foursale.testetecnico.victor.ms_product.core.model.Produto;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventoProdutoKafka implements EnviarMensagemProduto {

    @Value("${async.produto.topico}")
    private String eventoProdutoTopico;

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void enviar(Produto produto, OperacaoProduto operacao) {
        EventoProdutoBody body = new EventoProdutoBody(produto, operacao);
        kafkaTemplate.send(eventoProdutoTopico, new Gson().toJson(body));
    }
}
