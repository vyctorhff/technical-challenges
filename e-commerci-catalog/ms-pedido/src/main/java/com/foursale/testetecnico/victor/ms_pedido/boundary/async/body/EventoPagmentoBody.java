package com.foursale.testetecnico.victor.ms_pedido.boundary.async.body;

import com.foursale.testetecnico.victor.ms_pedido.core.model.Pedido;

import java.time.LocalDateTime;
import java.util.UUID;

public record EventoPagmentoBody (
        UUID idPedido,
        Double total,
        LocalDateTime dataCriacao
) {
}
