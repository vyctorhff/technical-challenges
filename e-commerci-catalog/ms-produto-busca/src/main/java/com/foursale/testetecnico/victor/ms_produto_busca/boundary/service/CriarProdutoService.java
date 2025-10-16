package com.foursale.testetecnico.victor.ms_produto_busca.boundary.service;

import com.foursale.testetecnico.victor.ms_produto_busca.boundary.repository.ProdutoJdbcRepository;
import com.foursale.testetecnico.victor.ms_produto_busca.core.application.CriarProdutoUserCase;
import com.foursale.testetecnico.victor.ms_produto_busca.core.model.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CriarProdutoService {

    private final ProdutoJdbcRepository produtoJdbcRepository;

    @Transactional
    public void criar(Produto produto) {
        new CriarProdutoUserCase(produtoJdbcRepository).criar(produto);
    }
}
