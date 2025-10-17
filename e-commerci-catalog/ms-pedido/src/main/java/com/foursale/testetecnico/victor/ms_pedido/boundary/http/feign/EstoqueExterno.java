package com.foursale.testetecnico.victor.ms_pedido.boundary.http.feign;

import com.foursale.testetecnico.victor.ms_pedido.core.application.port.ReservarEstoque;
import com.foursale.testetecnico.victor.ms_pedido.core.model.Pedido;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EstoqueExterno implements ReservarEstoque {

    private final EstoqueFeignClient estoqueFeignClient;

    @Override
    public boolean reservar(Pedido pedido) {
        return estoqueFeignClient.reservar(pedido.getProdutos());
    }
}
