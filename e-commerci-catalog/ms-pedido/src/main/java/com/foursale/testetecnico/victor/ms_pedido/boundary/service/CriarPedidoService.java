package com.foursale.testetecnico.victor.ms_pedido.boundary.service;

import com.foursale.testetecnico.victor.ms_pedido.boundary.async.EventoPagamentoRealizadoKfaka;
import com.foursale.testetecnico.victor.ms_pedido.boundary.http.feign.EstoqueExterno;
import com.foursale.testetecnico.victor.ms_pedido.boundary.repository.PedidoJdbcRepository;
import com.foursale.testetecnico.victor.ms_pedido.boundary.repository.ProdutoReservadoJdbcRepository;
import com.foursale.testetecnico.victor.ms_pedido.core.application.CriarPedidoUserCase;
import com.foursale.testetecnico.victor.ms_pedido.core.application.validator.CriarPedidoValidador;
import com.foursale.testetecnico.victor.ms_pedido.core.model.Pedido;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CriarPedidoService {

    private final EventoPagamentoRealizadoKfaka eventoPagamentoRealizadoKfaka;

    private final PedidoJdbcRepository pedidoJdbcRepository;

    private final ProdutoReservadoJdbcRepository produtoReservadoJdbcRepository;

    private final EstoqueExterno estoqueExterno;

    @Transactional
    public void criar(Pedido pedido) {
        new CriarPedidoUserCase(
                pedidoJdbcRepository,
                produtoReservadoJdbcRepository,
                estoqueExterno,
                eventoPagamentoRealizadoKfaka,
                new CriarPedidoValidador()
        ).criar(pedido);
    }
}
