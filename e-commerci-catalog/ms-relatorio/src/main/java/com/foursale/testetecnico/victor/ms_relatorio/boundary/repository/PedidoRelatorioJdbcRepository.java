package com.foursale.testetecnico.victor.ms_relatorio.boundary.repository;

import com.foursale.testetecnico.victor.ms_relatorio.boundary.repository.spring.PedidoRelatorioSpringJdbcRepository;
import com.foursale.testetecnico.victor.ms_relatorio.boundary.repository.spring.data.PedidoData;
import com.foursale.testetecnico.victor.ms_relatorio.core.application.ports.PedidoRelatorioRepository;
import com.foursale.testetecnico.victor.ms_relatorio.core.application.ports.PedidosPorIntervaloRepository;
import com.foursale.testetecnico.victor.ms_relatorio.core.model.PedidoRelatorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PedidoRelatorioJdbcRepository implements PedidoRelatorioRepository, PedidosPorIntervaloRepository {

    private final PedidoRelatorioSpringJdbcRepository pedidoRelatorioSpringJdbcRepository;

    @Override
    @Transactional
    public void salvar(PedidoRelatorio pedidoRelatorio) {
        PedidoData data = new PedidoData(pedidoRelatorio);
        this.pedidoRelatorioSpringJdbcRepository.save(data);
    }

    @Override
    public List<PedidoRelatorio> find(LocalDateTime inicio, LocalDateTime fim) {
        return this.pedidoRelatorioSpringJdbcRepository.findDataPagamentoBetween(inicio, fim)
                .stream()
                .map(PedidoData::toModel)
                .toList();
    }
}
