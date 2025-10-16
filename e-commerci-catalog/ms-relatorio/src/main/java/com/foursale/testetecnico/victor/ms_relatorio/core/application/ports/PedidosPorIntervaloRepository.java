package com.foursale.testetecnico.victor.ms_relatorio.core.application.ports;

import com.foursale.testetecnico.victor.ms_relatorio.core.model.PedidoRelatorio;

import java.time.LocalDateTime;
import java.util.List;

public interface PedidosPorIntervaloRepository {
    List<PedidoRelatorio> find(LocalDateTime inicio, LocalDateTime fim);
}
