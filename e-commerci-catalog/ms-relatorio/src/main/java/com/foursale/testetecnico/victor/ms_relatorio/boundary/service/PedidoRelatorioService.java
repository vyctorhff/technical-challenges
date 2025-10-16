package com.foursale.testetecnico.victor.ms_relatorio.boundary.service;

import com.foursale.testetecnico.victor.ms_relatorio.boundary.repository.PedidoRelatorioJdbcRepository;
import com.foursale.testetecnico.victor.ms_relatorio.boundary.repository.spring.CustomPedidoRelatorioRepository;
import com.foursale.testetecnico.victor.ms_relatorio.boundary.repository.spring.data.PedidoData;
import com.foursale.testetecnico.victor.ms_relatorio.core.application.ContabilizarFaturamentoUltimoMesUserCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoRelatorioService {

    private final CustomPedidoRelatorioRepository customPedidoRelatorioRepository;

    private final PedidoRelatorioJdbcRepository pedidoRelatorioJdbcRepository;

    public List<PedidoData> findUsuariosQueMaisCompraram(int numeroUsuarios) {
        return this.customPedidoRelatorioRepository.findUsuariosQueMaisCompraram(numeroUsuarios);
    }

    public List<PedidoData> findPedidoMedioPorUsuario() {
        return this.customPedidoRelatorioRepository.findPedidoMedioPorUsuario();
    }

    public Double countTotalFaturamentoPorMes() {
        return new ContabilizarFaturamentoUltimoMesUserCase(
                pedidoRelatorioJdbcRepository
        ).calcular();
    }
}
