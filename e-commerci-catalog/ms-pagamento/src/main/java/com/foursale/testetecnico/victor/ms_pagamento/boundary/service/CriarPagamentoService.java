package com.foursale.testetecnico.victor.ms_pagamento.boundary.service;

import com.foursale.testetecnico.victor.ms_pagamento.boundary.repository.PagamentoJdbcRepository;
import com.foursale.testetecnico.victor.ms_pagamento.core.model.Pagamento;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CriarPagamentoService {

    private final PagamentoJdbcRepository pagamentoJdbcRepository;

    @Transactional
    public void criar(Pagamento pagamento) {
    }
}
