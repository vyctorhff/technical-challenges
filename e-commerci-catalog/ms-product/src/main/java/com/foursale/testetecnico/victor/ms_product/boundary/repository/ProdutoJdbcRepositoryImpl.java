package com.foursale.testetecnico.victor.ms_product.boundary.repository;

import com.foursale.testetecnico.victor.ms_product.boundary.repository.dataModel.ProdutoData;
import com.foursale.testetecnico.victor.ms_product.core.application.ports.ProdutoRepository;
import com.foursale.testetecnico.victor.ms_product.core.model.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProdutoJdbcRepositoryImpl implements ProdutoRepository {

    private final ProdutoSpringJdbcRepository produtoSpringJdbcRepository;

    @Override
    public void salvar(Produto produto) {
        ProdutoData data = new ProdutoData(produto);
        this.produtoSpringJdbcRepository.save(data);
    }

    @Override
    public void remover(Produto produto) {
        ProdutoData data = new ProdutoData(produto);
        this.produtoSpringJdbcRepository.delete(data);
    }
}
