package com.foursale.testetecnico.victor.ms_produto_busca.core.application;

import com.foursale.testetecnico.victor.ms_produto_busca.core.application.ports.ProdutoRepository;
import com.foursale.testetecnico.victor.ms_produto_busca.core.exception.CriarProdutoException;
import com.foursale.testetecnico.victor.ms_produto_busca.core.model.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CriarProdutoUserCase {

    private final ProdutoRepository produtoRepository;

    public void criar(Produto produto) throws CriarProdutoException {
        log.info("Criando produto");
    }
}
