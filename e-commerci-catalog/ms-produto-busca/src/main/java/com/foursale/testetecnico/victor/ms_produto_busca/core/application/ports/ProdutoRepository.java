package com.foursale.testetecnico.victor.ms_produto_busca.core.application.ports;

import com.foursale.testetecnico.victor.ms_produto_busca.core.model.Produto;

public interface ProdutoRepository {

    void criar(Produto produto);

    void remover(Produto produto);
}
