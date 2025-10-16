package com.foursale.testetecnico.victor.ms_relatorio.boundary.repository.spring;

import com.foursale.testetecnico.victor.ms_relatorio.boundary.repository.spring.data.PedidoData;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CustomPedidoRelatorioRepository {

    @Modifying
    @Query("SELECT * FROM tb_pedido_relatorio LIMIT :numeroUsuario")
    List<PedidoData> findUsuariosQueMaisCompraram(@Param("numeroUsuario") int numeroUsuarios);

    @Modifying
    @Query("SELECT * FROM tb_pedido_relatorio")
    List<PedidoData> findPedidoMedioPorUsuario();

    @Modifying
    @Query("SELECT * FROM tb_pedido_relatorio")
    List<PedidoData> countTotalFaturamentoPorMes(LocalDate inicio, LocalDate fim);
}
