package com.foursale.testetecnico.victor.ms_pagamento.core.application.port;

import com.foursale.testetecnico.victor.ms_pagamento.core.model.Pedido;

public interface EnviarMensagemPedidoPago {
    void enviar(Pedido pedido);
}
