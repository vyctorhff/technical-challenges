package com.foursale.testetecnico.victor.ms_pagamento.boundary.http.dto;

import com.foursale.testetecnico.victor.ms_pagamento.core.model.Pagamento;
import com.foursale.testetecnico.victor.ms_pagamento.core.model.Pedido;

import java.util.UUID;

public record PagamentoRequestDTO (
        UUID idPagamento,
        UUID idPedido
) {
    public Pagamento toModel() {
        Pagamento pagamento = new Pagamento();
        pagamento.setId(idPagamento);
        pagamento.setPedido(new Pedido());
        pagamento.getPedido().setId(idPedido);
        return pagamento;
    }
}
