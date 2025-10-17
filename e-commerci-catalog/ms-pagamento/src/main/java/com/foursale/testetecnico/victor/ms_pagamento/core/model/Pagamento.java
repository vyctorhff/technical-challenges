package com.foursale.testetecnico.victor.ms_pagamento.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Pagamento {

    private UUID id;

    private Double total;

    private PagamentoStatus status;

    private FormaPagamento formaPagamento;

    private Carteira carteira;

    private Pedido pedido;

    private LocalDateTime dataPedido;

    private LocalDateTime dataPagamento;
}
