package com.foursale.testetecnico.victor.ms_pagamento.core.application;

import com.foursale.testetecnico.victor.ms_pagamento.core.application.port.PagamentoRepository;
import com.foursale.testetecnico.victor.ms_pagamento.core.exception.CriarPagamentoException;
import com.foursale.testetecnico.victor.ms_pagamento.core.model.Pagamento;
import com.foursale.testetecnico.victor.ms_pagamento.core.model.PagamentoStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CriarPagamentoUserCase {

    private final PagamentoRepository pagamentoRepository;

    public void criar(Pagamento pagamento) throws CriarPagamentoException {
        log.info("Salvando pagamento");
        pagamento.setStatus(PagamentoStatus.PENDENTE);
        pagamentoRepository.salvar(pagamento);
    }
}
