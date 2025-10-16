package com.foursale.testetecnico.victor.ms_product.core.application.ports;

import com.foursale.testetecnico.victor.ms_product.core.model.OperacaoProduto;
import com.foursale.testetecnico.victor.ms_product.core.model.Produto;

public interface EnviarMensagemProduto {
    void enviar(Produto produto, OperacaoProduto operacao);
}
