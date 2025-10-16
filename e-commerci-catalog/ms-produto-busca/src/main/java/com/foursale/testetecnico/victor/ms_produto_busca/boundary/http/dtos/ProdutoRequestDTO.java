package com.foursale.testetecnico.victor.ms_produto_busca.boundary.http.dtos;

import org.apache.commons.lang3.StringUtils;

public record ProdutoRequestDTO (
        String nome,
        String categoria,
        FaixaPrecoRequestDTO faixaPreco
) {

    public boolean hasNome() {
        return StringUtils.isNotBlank(nome);
    }

    public boolean hasCategoria() {
        return StringUtils.isNotBlank(categoria);
    }

    public boolean hasFaixaPreco() {
        return faixaPreco != null;
    }
}
