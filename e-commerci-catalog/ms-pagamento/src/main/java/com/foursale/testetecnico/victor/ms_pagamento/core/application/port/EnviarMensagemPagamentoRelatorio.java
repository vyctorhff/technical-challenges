package com.foursale.testetecnico.victor.ms_pagamento.core.application.port;

import com.foursale.testetecnico.victor.ms_pagamento.core.model.Pagamento;

public interface EnviarMensagemPagamentoRelatorio {
    void enviar(Pagamento pagamento);
}
