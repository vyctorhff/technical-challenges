package com.foursale.testetecnico.victor.ms_relatorio.boundary.service;

import com.foursale.testetecnico.victor.ms_relatorio.boundary.repository.spring.CustomPedidoRelatorioRepository;
import com.foursale.testetecnico.victor.ms_relatorio.boundary.repository.spring.data.PedidoData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoRelatorioService {

    private final CustomPedidoRelatorioRepository customPedidoRelatorioRepository;

    public List<PedidoData> findUsuariosQueMaisCompraram(int numeroUsuarios) {
//        return this.customPedidoRelatorioRepository.findUsuariosQueMaisCompraram(numeroUsuarios);
        return null;
    }

    public List<PedidoData> findPedidoMedioPorUsuario() {
//        return this.customPedidoRelatorioRepository.findPedidoMedioPorUsuario();
        return null;
    }

    public Double countTotalFaturamentoPorMes() {
        LocalDate fim = LocalDate.now();
        LocalDate inicio = fim.minusMonths(1);
//        return this.customPedidoRelatorioRepository.countTotalFaturamentoPorMes(inicio, fim);
        return null;
    }
}
