package com.foursale.testetecnico.victor.ms_produto_busca.boundary.repository;

import com.foursale.testetecnico.victor.ms_produto_busca.boundary.repository.data.ProdutoData;
import com.foursale.testetecnico.victor.ms_produto_busca.core.application.ports.ProdutoRepository;
import com.foursale.testetecnico.victor.ms_produto_busca.core.model.Produto;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoJdbcRepository implements ProdutoRepository {

    private ProdutoSpringJdbcRepository produtoSpringJdbcRepository;

    @Override
    public void criar(Produto produto) {
        ProdutoData data = new ProdutoData(produto);
        this.produtoSpringJdbcRepository.save(data);
    }

    @Override
    public void remover(Produto produto) {

    }
}
