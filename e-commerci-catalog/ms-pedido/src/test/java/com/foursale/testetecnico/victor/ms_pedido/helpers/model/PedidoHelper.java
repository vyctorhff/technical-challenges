package com.foursale.testetecnico.victor.ms_pedido.helpers.model;

import com.foursale.testetecnico.victor.ms_pedido.core.model.Pedido;
import com.foursale.testetecnico.victor.ms_pedido.core.model.PedidoStatus;
import com.foursale.testetecnico.victor.ms_pedido.core.model.Usuario;

import java.util.UUID;

public class PedidoHelper {

    public static Pedido getBase() {
        Pedido pedido = new Pedido();
        pedido.setId(UUID.randomUUID());
        pedido.setPedidoStatus(PedidoStatus.PENDENTE);
        pedido.setTotal(2000.0);
        pedido.setUsuario(new Usuario());
        return pedido;
    }

    public static Pedido getCriar() {
        Pedido pedido = getBase();
        pedido.setDataCriacao(null);
        return pedido;
    }
}
