package com.foursale.testetecnico.victor.ms_produto_busca.core.application;

import com.foursale.testetecnico.victor.ms_produto_busca.core.application.ports.ProdutoRepository;
import com.foursale.testetecnico.victor.ms_produto_busca.core.exception.RemoverProdutoException;
import com.foursale.testetecnico.victor.ms_produto_busca.core.model.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class RemoverProdutoUserCase {

    private ProdutoRepository produtoRepository;

    public void remover(Produto produto) throws RemoverProdutoException {
        log.info("Removendo produto");
        this.produtoRepository.remover(produto);
    }
}
