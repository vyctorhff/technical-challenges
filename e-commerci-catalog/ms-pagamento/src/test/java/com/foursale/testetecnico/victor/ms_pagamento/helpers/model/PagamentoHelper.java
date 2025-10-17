package com.foursale.testetecnico.victor.ms_pagamento.helpers.model;

import com.foursale.testetecnico.victor.ms_pagamento.core.model.Pagamento;
import com.foursale.testetecnico.victor.ms_pagamento.core.model.PagamentoStatus;

import java.util.UUID;

public class PagamentoHelper {
    private static Pagamento getBase() {
        Pagamento pagamento = new Pagamento();
        pagamento.setPedido(PedidoHelper.getBase());
        pagamento.setStatus(PagamentoStatus.PENDENTE);
        pagamento.setCarteira(CarteiraHelper.getBase());
        return pagamento;
    }

    public static Pagamento getRealizarPagamento() {
        Pagamento pagamento = getBase();
        pagamento.setId(UUID.randomUUID());
        return pagamento;
    }
}
