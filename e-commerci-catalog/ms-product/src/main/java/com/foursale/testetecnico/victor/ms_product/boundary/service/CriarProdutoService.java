package com.foursale.testetecnico.victor.ms_product.boundary.service;

import com.foursale.testetecnico.victor.ms_product.boundary.async.EventoAtualizarEstoqueKafka;
import com.foursale.testetecnico.victor.ms_product.boundary.async.EventoProdutoKafka;
import com.foursale.testetecnico.victor.ms_product.boundary.repository.ProdutoJdbcRepositoryImpl;
import com.foursale.testetecnico.victor.ms_product.core.application.CriarProdutoUserCase;
import com.foursale.testetecnico.victor.ms_product.core.application.validation.CriarProdutoValidator;
import com.foursale.testetecnico.victor.ms_product.core.model.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CriarProdutoService {

    private final EventoProdutoKafka eventoProdutoKafka;

    private final EventoAtualizarEstoqueKafka eventoAtualizarEstoqueKafka;

    private final ProdutoJdbcRepositoryImpl produtoJdbcRepositoryImpl;

    @Transactional
    public void criar(Produto produto) {
        new CriarProdutoUserCase(
                new CriarProdutoValidator(),
                produtoJdbcRepositoryImpl,
                eventoProdutoKafka,
                eventoAtualizarEstoqueKafka
        ).criar(produto);
    }
}
