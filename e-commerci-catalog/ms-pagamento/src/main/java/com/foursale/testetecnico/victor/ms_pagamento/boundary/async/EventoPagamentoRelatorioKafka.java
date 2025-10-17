package com.foursale.testetecnico.victor.ms_pagamento.boundary.async;

import com.foursale.testetecnico.victor.ms_pagamento.core.application.port.EnviarMensagemPagamentoRelatorio;
import com.foursale.testetecnico.victor.ms_pagamento.core.model.Pagamento;
import org.springframework.stereotype.Service;

@Service
public class EventoPagamentoRelatorioKafka implements EnviarMensagemPagamentoRelatorio {

    @Override
    public void enviar(Pagamento pagamento) {
    }
}
