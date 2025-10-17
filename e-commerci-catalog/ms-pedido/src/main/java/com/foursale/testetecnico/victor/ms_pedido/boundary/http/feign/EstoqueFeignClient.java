package com.foursale.testetecnico.victor.ms_pedido.boundary.http.feign;

import com.foursale.testetecnico.victor.ms_pedido.core.model.Produto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "EstoqueFeign", url = "${integracao.feign.estoque.url}")
public interface EstoqueFeignClient {

    @PostMapping("/reservar")
    boolean reservar(Produto produto);

    @PostMapping("/reservar-produtos")
    boolean reservar(List<Produto> produto);
}
