package com.foursale.testetecnico.victor.ms_product.boundary.service;

import com.foursale.testetecnico.victor.ms_product.boundary.async.EventoAtualizarEstoqueKafka;
import com.foursale.testetecnico.victor.ms_product.boundary.async.EventoProdutoKafka;
import com.foursale.testetecnico.victor.ms_product.boundary.repository.ProdutoJdbcRepositoryImpl;
import com.foursale.testetecnico.victor.ms_product.core.application.RemoverProdutoUserCase;
import com.foursale.testetecnico.victor.ms_product.core.model.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RemoverProdutoService {

    private final EventoProdutoKafka eventoProdutoKafka;

    private final EventoAtualizarEstoqueKafka eventoAtualizarEstoqueKafka;

    private final ProdutoJdbcRepositoryImpl produtoJdbcRepository;

    public void remover(UUID uuid) {
        Produto produto = new Produto();
        produto.setId(uuid);

        new RemoverProdutoUserCase(
                produtoJdbcRepository,
                eventoProdutoKafka,
                eventoAtualizarEstoqueKafka
        ).remover(produto);
    }
}
