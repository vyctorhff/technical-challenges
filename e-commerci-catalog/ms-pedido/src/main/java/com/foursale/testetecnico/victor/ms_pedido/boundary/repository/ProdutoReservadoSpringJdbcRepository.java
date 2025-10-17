package com.foursale.testetecnico.victor.ms_pedido.boundary.repository;

import com.foursale.testetecnico.victor.ms_pedido.boundary.repository.data.ProdutoReservadoData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProdutoReservadoSpringJdbcRepository extends CrudRepository<ProdutoReservadoData, UUID> {
}
