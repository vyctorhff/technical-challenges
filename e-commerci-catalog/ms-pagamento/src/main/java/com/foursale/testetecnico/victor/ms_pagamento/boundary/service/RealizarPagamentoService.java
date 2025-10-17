package com.foursale.testetecnico.victor.ms_pagamento.boundary.service;

import com.foursale.testetecnico.victor.ms_pagamento.boundary.async.EventoPagamentoRelatorioKafka;
import com.foursale.testetecnico.victor.ms_pagamento.boundary.async.EventoPedidoPagoKafka;
import com.foursale.testetecnico.victor.ms_pagamento.boundary.http.feign.OperadoraCartaoExternaFake;
import com.foursale.testetecnico.victor.ms_pagamento.boundary.repository.PagamentoJdbcRepository;
import com.foursale.testetecnico.victor.ms_pagamento.core.application.RealizarPagamentoCartaoUserCase;
import com.foursale.testetecnico.victor.ms_pagamento.core.model.Pagamento;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RealizarPagamentoService {

    private final OperadoraCartaoExternaFake operadoraCartaoExternaFake;

    private final EventoPedidoPagoKafka eventoPedidoPagoKafka;

    private final EventoPagamentoRelatorioKafka eventoPagamentoRelatorioKafka;

    private final PagamentoJdbcRepository pagamentoJdbcRepository;

    @Transactional
    public void pagar(Pagamento pagamento) {
        new RealizarPagamentoCartaoUserCase(
                operadoraCartaoExternaFake,
                eventoPedidoPagoKafka,
                eventoPagamentoRelatorioKafka,
                pagamentoJdbcRepository
        ).pagar(pagamento);
    }
}
