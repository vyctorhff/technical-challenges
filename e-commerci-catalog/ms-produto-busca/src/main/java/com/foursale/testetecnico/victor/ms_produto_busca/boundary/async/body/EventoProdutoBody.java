package com.foursale.testetecnico.victor.ms_produto_busca.boundary.async.body;

import com.foursale.testetecnico.victor.ms_produto_busca.core.model.OperacaoProduto;
import com.foursale.testetecnico.victor.ms_produto_busca.core.model.Produto;

public record EventoProdutoBody (
        Produto produto,
        OperacaoProduto operacao
) {
}