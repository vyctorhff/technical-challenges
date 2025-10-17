package com.foursale.testetecnico.victor.ms_pedido.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Pedido {
    private UUID id;

    private Double total;

    private PedidoStatus pedidoStatus;

    private Usuario usuario;

    private List<Produto> produtos;

    private LocalDateTime dataCriacao;

    public Double calcularTotal() {
        return this.produtos.stream()
                .map(produto -> BigDecimal.valueOf(produto.getPreco()))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .doubleValue();
    }
}
