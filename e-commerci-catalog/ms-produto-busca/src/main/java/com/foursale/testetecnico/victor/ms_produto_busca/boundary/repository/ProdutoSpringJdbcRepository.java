package com.foursale.testetecnico.victor.ms_produto_busca.boundary.repository;

import com.foursale.testetecnico.victor.ms_produto_busca.boundary.repository.data.ProdutoData;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProdutoSpringJdbcRepository extends ElasticsearchRepository<ProdutoData, UUID> {
}
