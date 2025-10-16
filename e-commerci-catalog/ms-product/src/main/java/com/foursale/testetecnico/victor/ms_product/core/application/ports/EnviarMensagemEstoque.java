package com.foursale.testetecnico.victor.ms_product.core.application.ports;

import com.foursale.testetecnico.victor.ms_product.core.model.OperacaoEstoque;
import com.foursale.testetecnico.victor.ms_product.core.model.Produto;

public interface EnviarMensagemEstoque {
    void enviar(Produto produto, OperacaoEstoque operacao);
}
