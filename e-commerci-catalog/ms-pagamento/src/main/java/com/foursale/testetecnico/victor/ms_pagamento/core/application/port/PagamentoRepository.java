package com.foursale.testetecnico.victor.ms_pagamento.core.application.port;

import com.foursale.testetecnico.victor.ms_pagamento.core.model.Pagamento;

import java.util.UUID;

public interface PagamentoRepository {
    void salvar(Pagamento pagamento);

    Pagamento buscarPorId(UUID id);
}
