package com.foursale.testetecnico.victor.ms_pagamento.boundary.http.feign;

import com.foursale.testetecnico.victor.ms_pagamento.core.application.port.ConfirmarPagamentoCartao;
import com.foursale.testetecnico.victor.ms_pagamento.core.model.Carteira;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OperadoraCartaoExternaFake implements ConfirmarPagamentoCartao {
    @Override
    public void confirmar(Carteira carteira, Double total) {
        if (total <= 0.0) {
            throw new IllegalArgumentException("Nao autorizado");
        }
    }
}
