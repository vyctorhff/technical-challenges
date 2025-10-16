package com.foursale.testetecnico.victor.ms_relatorio.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class PedidoRelatorio {

    private UUID id;

    private BigDecimal total;

    private LocalDateTime dataPedido;
    private LocalDateTime dataPagamento;

    private Usuario usuario;
    private Pagamento pagamento;
}
