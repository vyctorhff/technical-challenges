package com.foursale.testetecnico.victor.ms_relatorio.boundary.repository.spring;

import com.foursale.testetecnico.victor.ms_relatorio.boundary.repository.spring.data.PedidoData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface PedidoRelatorioSpringJdbcRepository extends CrudRepository<PedidoData, UUID> {

    List<PedidoData> findDataPagamentoBetween(LocalDateTime inicio, LocalDateTime fim);
}
