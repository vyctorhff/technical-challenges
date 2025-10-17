package com.foursale.testetecnico.victor.ms_product.core.application.ports;

import com.foursale.testetecnico.victor.ms_product.core.model.Produto;

import java.util.UUID;

public interface ProdutoRepository {
    void salvar(Produto produto);

    void remover(Produto produto);

    boolean exists(UUID id);
}
