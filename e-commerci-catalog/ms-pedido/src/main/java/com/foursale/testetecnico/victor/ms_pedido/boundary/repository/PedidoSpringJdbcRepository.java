package com.foursale.testetecnico.victor.ms_pedido.boundary.repository;

import com.foursale.testetecnico.victor.ms_pedido.boundary.repository.data.PedidoData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PedidoSpringJdbcRepository extends CrudRepository<PedidoData, UUID> {
}
