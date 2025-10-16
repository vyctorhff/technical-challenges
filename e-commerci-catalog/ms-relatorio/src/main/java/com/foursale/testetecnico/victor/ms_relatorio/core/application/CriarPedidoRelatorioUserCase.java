package com.foursale.testetecnico.victor.ms_relatorio.core.application;

import com.foursale.testetecnico.victor.ms_relatorio.core.application.ports.PedidoRelatorioRepository;
import com.foursale.testetecnico.victor.ms_relatorio.core.model.PedidoRelatorio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class CriarPedidoRelatorioUserCase {

    private final PedidoRelatorioRepository pedidoRelatorioRepository;

    public void criar(PedidoRelatorio pedidoRelatorio) {
        log.info("Salvando pedido pago para o relatorio");
        this.pedidoRelatorioRepository.salvar(pedidoRelatorio);
    }
}
