package com.foursale.testetecnico.victor.ms_pedido.core.application.port;

import com.foursale.testetecnico.victor.ms_pedido.core.model.Pedido;

public interface PedidoRepository {
    void salvar(Pedido pedido);
}
