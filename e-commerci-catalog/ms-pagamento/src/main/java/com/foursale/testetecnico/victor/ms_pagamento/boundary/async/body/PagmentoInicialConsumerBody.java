package com.foursale.testetecnico.victor.ms_pagamento.boundary.async.body;

import com.foursale.testetecnico.victor.ms_pagamento.core.model.Pagamento;
import com.foursale.testetecnico.victor.ms_pagamento.core.model.Pedido;

import java.time.LocalDateTime;
import java.util.UUID;

public record PagmentoInicialConsumerBody(
        UUID idPedido,
        Double total,
        LocalDateTime dataCriacao
) {

    public Pagamento toModel() {
        Pagamento pagamento = new Pagamento();
        pagamento.setPedido(new Pedido());
        pagamento.getPedido().setId(idPedido);
        pagamento.setTotal(total);
        pagamento.setDataPedido(dataCriacao);
        return pagamento;
    }
}
