package com.foursale.testetecnico.victor.ms_relatorio.boundary.repository.spring;

import com.foursale.testetecnico.victor.ms_relatorio.boundary.repository.spring.data.PedidoData;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface CustomPedidoRelatorioRepository extends CrudRepository<PedidoData, UUID> {

    @Modifying
    @Query("SELECT * FROM vw_top_usuario LIMIT :numeroUsuario")
    List<PedidoData> findUsuariosQueMaisCompraram(@Param("numeroUsuario") int numeroUsuarios);

    @Modifying
    @Query("SELECT * FROM vw_pedido_medio")
    List<PedidoData> findPedidoMedioPorUsuario();

    @Modifying
    @Query("SELECT SUM(total_pago) FROM tb_pedido_relatorio WHERE dt_pagamento BETWEEN ")
    Double countTotalFaturamentoPorMes(LocalDate inicio, LocalDate fim);

    List<PedidoData> findByDataPagamentoBetween(LocalDateTime inicio, LocalDateTime fim);
}
