package com.foursale.testetecnico.victor.ms_relatorio.boundary.service;

import com.foursale.testetecnico.victor.ms_relatorio.boundary.repository.PedidoRelatorioJdbcRepository;
import com.foursale.testetecnico.victor.ms_relatorio.core.application.CriarPedidoRelatorioUserCase;
import com.foursale.testetecnico.victor.ms_relatorio.core.model.PedidoRelatorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PagamentoRealizadoService {

    private final PedidoRelatorioJdbcRepository pedidoRelatorioJdbcRepository;

    public void criarPedidoPago(PedidoRelatorio pedidoRelatorio) {
        new CriarPedidoRelatorioUserCase(
                pedidoRelatorioJdbcRepository
        ).criar(pedidoRelatorio);
    }
}
