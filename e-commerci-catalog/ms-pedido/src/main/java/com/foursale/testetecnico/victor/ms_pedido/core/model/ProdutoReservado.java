package com.foursale.testetecnico.victor.ms_pedido.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class ProdutoReservado {

    private UUID id;

    private Double preco;

    private String nome;
    private String descricao;

    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    private Categoria categoria;
}