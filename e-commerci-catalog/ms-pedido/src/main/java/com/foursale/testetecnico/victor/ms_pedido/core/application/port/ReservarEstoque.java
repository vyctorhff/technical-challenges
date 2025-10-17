package com.foursale.testetecnico.victor.ms_pedido.core.application.port;

import com.foursale.testetecnico.victor.ms_pedido.core.model.Pedido;

public interface ReservarEstoque {
    boolean reservar(Pedido pedido);
}
