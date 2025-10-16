package com.foursale.testetecnico.victor.ms_relatorio.core.application;

import com.foursale.testetecnico.victor.ms_relatorio.core.application.ports.PedidosPorIntervaloRepository;
import com.foursale.testetecnico.victor.ms_relatorio.core.model.PedidoRelatorio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

@RequiredArgsConstructor
@Slf4j
public class ContabilizarFaturamentoUltimoMesUserCase {

    private static DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final PedidosPorIntervaloRepository pedidosUltimoMesRepository;

    public Double calcular() {
        LocalDateTime inicio = LocalDateTime.now().minusMonths(1);
        LocalDateTime fim = LocalDateTime.now();

        log.info("Calculando faturamento de %s à %s", formatador.format(inicio), formatador.format(fim));

        BigDecimal result = pedidosUltimoMesRepository.find(LocalDateTime.now(), LocalDateTime.now())
                .stream()
                .map(PedidoRelatorio::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return result.doubleValue();
    }
}
