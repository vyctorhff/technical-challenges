package com.foursale.testetecnico.victor.ms_produto_busca.boundary.http.dtos;

public record FaixaPrecoRequestDTO (
        Double precoMinimo,
        Double precoMaximo
) {
}
