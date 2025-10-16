package com.foursale.testetecnico.victor.ms_product.core.application.ports;

import com.foursale.testetecnico.victor.ms_product.core.model.Produto;

public interface ProdutoRepository {
    void salvar(Produto produto);

    void remover(Produto produto);
}
