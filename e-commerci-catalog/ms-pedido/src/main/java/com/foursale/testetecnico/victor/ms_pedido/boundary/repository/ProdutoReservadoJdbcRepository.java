package com.foursale.testetecnico.victor.ms_pedido.boundary.repository;

import com.foursale.testetecnico.victor.ms_pedido.boundary.repository.data.ProdutoReservadoData;
import com.foursale.testetecnico.victor.ms_pedido.core.application.port.ReservarProduto;
import com.foursale.testetecnico.victor.ms_pedido.core.model.Pedido;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProdutoReservadoJdbcRepository implements ReservarProduto {

    private final ProdutoReservadoSpringJdbcRepository produtoReservadoSpringJdbcRepository;

    @Override
    public void reservar(Pedido pedido) {
        pedido.getProdutos().stream()
                .forEach(produto -> {
                    ProdutoReservadoData data = new ProdutoReservadoData(produto);
                    this.produtoReservadoSpringJdbcRepository.save(data);
                });
    }
}
