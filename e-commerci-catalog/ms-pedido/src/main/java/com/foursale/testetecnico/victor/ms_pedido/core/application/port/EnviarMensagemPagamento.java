package com.foursale.testetecnico.victor.ms_pedido.core.application.port;

import com.foursale.testetecnico.victor.ms_pedido.core.model.OperacaoPagamento;
import com.foursale.testetecnico.victor.ms_pedido.core.model.Pedido;

public interface EnviarMensagemPagamento {
    void enviar(Pedido pedido, OperacaoPagamento operacaoPagamento);
}
