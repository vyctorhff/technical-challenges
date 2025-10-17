package com.foursale.testetecnico.victor.ms_pedido.boundary.repository;

import com.foursale.testetecnico.victor.ms_pedido.boundary.repository.data.PedidoData;
import com.foursale.testetecnico.victor.ms_pedido.core.application.port.PedidoRepository;
import com.foursale.testetecnico.victor.ms_pedido.core.model.Pedido;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PedidoJdbcRepository implements PedidoRepository {

    private final PedidoSpringJdbcRepository pedidoSpringJdbcRepository;

    @Override
    public void salvar(Pedido pedido) {
        PedidoData data = new PedidoData(pedido);
        this.pedidoSpringJdbcRepository.save(data);
    }
}
