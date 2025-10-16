package com.foursale.testetecnico.victor.ms_product.boundary.async.body;

import com.foursale.testetecnico.victor.ms_product.core.model.OperacaoProduto;
import com.foursale.testetecnico.victor.ms_product.core.model.Produto;

public record EventoProdutoBody (
        Produto produto,
        OperacaoProduto operacao
) {
}
