package com.foursale.testetecnico.victor.ms_product.boundary.repository;

import com.foursale.testetecnico.victor.ms_product.boundary.repository.dataModel.ProdutoData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProdutoSpringJdbcRepository extends CrudRepository<ProdutoData, UUID> {
}
