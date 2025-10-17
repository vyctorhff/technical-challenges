package com.foursale.testetecnico.victor.ms_pagamento.boundary.repository;

import com.foursale.testetecnico.victor.ms_pagamento.boundary.repository.data.PagamentoData;
import com.foursale.testetecnico.victor.ms_pagamento.core.application.port.PagamentoRepository;
import com.foursale.testetecnico.victor.ms_pagamento.core.exception.RealizarPagamentoCartaoException;
import com.foursale.testetecnico.victor.ms_pagamento.core.model.Pagamento;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PagamentoJdbcRepository implements PagamentoRepository {

    private final PagamentoSpringJdbcRepository pagamentoSpringJdbcRepository;

    @Override
    public void salvar(Pagamento pagamento) {
        PagamentoData data = new PagamentoData(pagamento);
        this.pagamentoSpringJdbcRepository.save(data);
    }

    @Override
    public Pagamento buscarPorId(UUID id) {
        Optional<PagamentoData> data = this.pagamentoSpringJdbcRepository.findById(id);
        return data
                .map(PagamentoData::toModel)
                .orElseThrow(() -> new RealizarPagamentoCartaoException(""));
    }
}
