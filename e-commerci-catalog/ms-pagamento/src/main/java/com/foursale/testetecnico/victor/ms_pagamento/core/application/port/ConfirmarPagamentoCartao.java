package com.foursale.testetecnico.victor.ms_pagamento.core.application.port;

import com.foursale.testetecnico.victor.ms_pagamento.core.model.Carteira;

public interface ConfirmarPagamentoCartao {
    void confirmar(Carteira carteira, Double total);
}
