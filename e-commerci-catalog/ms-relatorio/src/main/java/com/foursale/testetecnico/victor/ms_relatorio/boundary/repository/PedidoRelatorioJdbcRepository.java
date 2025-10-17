package com.foursale.testetecnico.victor.ms_relatorio.boundary.repository;

import com.foursale.testetecnico.victor.ms_relatorio.boundary.repository.spring.CustomPedidoRelatorioRepository;
import com.foursale.testetecnico.victor.ms_relatorio.boundary.repository.spring.data.PedidoData;
import com.foursale.testetecnico.victor.ms_relatorio.core.application.ports.PedidoRelatorioRepository;
import com.foursale.testetecnico.victor.ms_relatorio.core.application.ports.PedidosPorIntervaloRepository;
import com.foursale.testetecnico.victor.ms_relatorio.core.model.PedidoRelatorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoRelatorioJdbcRepository implements PedidoRelatorioRepository, PedidosPorIntervaloRepository {

//    private final CustomPedidoRelatorioRepository customPedidoRelatorioRepository;

    @Override
    @Transactional
    public void salvar(PedidoRelatorio pedidoRelatorio) {
        PedidoData data = new PedidoData(pedidoRelatorio);
//        this.customPedidoRelatorioRepository.save(data);
    }

    @Override
    public List<PedidoRelatorio> find(LocalDateTime inicio, LocalDateTime fim) {
//        return this.customPedidoRelatorioRepository.findByDataPagamentoBetween(inicio, fim)
//                .stream()
//                .map(PedidoData::toModel)
//                .toList();
        return null;
    }
}
