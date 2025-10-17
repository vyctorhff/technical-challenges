package com.foursale.testetecnico.victor.ms_pagamento.helpers.model;


import com.foursale.testetecnico.victor.ms_pagamento.core.model.Pedido;

import java.util.UUID;

public class PedidoHelper {

    public static Pedido getBase() {
        Pedido pedido = new Pedido();
        pedido.setId(UUID.randomUUID());
        return pedido;
    }

    public static Pedido getCriar() {
        Pedido pedido = getBase();
        return pedido;
    }
}
