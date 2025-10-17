package com.foursale.testetecnico.victor.ms_pagamento.boundary.repository;

import com.foursale.testetecnico.victor.ms_pagamento.boundary.repository.data.PagamentoData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PagamentoSpringJdbcRepository extends CrudRepository<PagamentoData, UUID> {
}
