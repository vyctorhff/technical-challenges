package com.foursale.testetecnico.victor.ms_produto_busca.boundary.repository;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.foursale.testetecnico.victor.ms_produto_busca.boundary.http.dtos.ProdutoRequestDTO;
import com.foursale.testetecnico.victor.ms_produto_busca.boundary.repository.data.ProdutoData;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomProdutoRepository {

    private final ElasticsearchOperations operations;

    public List<ProdutoData> filter(ProdutoRequestDTO dto) {
        Criteria finalCriteria = new Criteria();

        if (dto.hasFaixaPreco()) {
            Criteria precoCriteria = new Criteria("preco")
                    .between(
                            dto.faixaPreco().precoMinimo(),
                            dto.faixaPreco().precoMaximo()
                    );
            finalCriteria = finalCriteria.and(precoCriteria);
        }

        if (dto.hasNome()) {
            Criteria nomeCriteria = new Criteria("nome")
                    .fuzzy(dto.nome());
            finalCriteria = finalCriteria.and(nomeCriteria);
        }

        if (dto.hasCategoria()) {
            Criteria categoriaCriteria = new Criteria("categoria.nome")
                    .contains(dto.categoria());
            finalCriteria = finalCriteria.and(categoriaCriteria);
        }

        Query query = new CriteriaQuery(finalCriteria);

        SearchHits<ProdutoData> searchHits = operations.search(query, ProdutoData.class);
        return searchHits.stream()
                .map(SearchHit::getContent)
                .toList();
    }
}
