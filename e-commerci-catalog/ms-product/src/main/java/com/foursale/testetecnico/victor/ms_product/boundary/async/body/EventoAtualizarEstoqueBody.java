package com.foursale.testetecnico.victor.ms_product.boundary.async.body;

import com.foursale.testetecnico.victor.ms_product.core.model.OperacaoEstoque;
import com.foursale.testetecnico.victor.ms_product.core.model.Produto;

public record EventoAtualizarEstoqueBody (Produto produto, OperacaoEstoque operacao) {
}
