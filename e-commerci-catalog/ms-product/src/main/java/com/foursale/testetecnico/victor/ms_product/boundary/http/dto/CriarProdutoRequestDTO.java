package com.foursale.testetecnico.victor.ms_product.boundary.http.dto;

import com.foursale.testetecnico.victor.ms_product.core.model.Produto;

import java.util.UUID;

public record CriarProdutoRequestDTO(
        String nome,
        String descricao,
        Double preco,
        Long estoque,
        UUID idCategoria
) {

    public Produto toModel() {
        Produto produto = new Produto();
        // TODO: fazer
        return produto;
    }
}
