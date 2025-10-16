package com.foursale.testetecnico.victor.ms_produto_busca.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Produto {
    private UUID id;

    private Double preco;

    private String nome;
    private String descricao;

    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    private Categoria categoria;
    private Estoque estoque;
}
