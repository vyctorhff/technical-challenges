package com.foursale.testetecnico.victor.ms_pedido.core.application.validator;

import com.foursale.testetecnico.victor.ms_pedido.core.exception.CriarPedidoException;
import com.foursale.testetecnico.victor.ms_pedido.core.model.Pedido;

public class CriarPedidoValidador {

    public void validar(Pedido pedido) throws CriarPedidoException {
        CriarPedidoException e = new CriarPedidoException("Falha ao processar o pedido");

        if (pedido.getUsuario() == null) {
            e.addError("Pedido sem usuario");
        }

        if (pedido.getProdutos().isEmpty()) {
            e.addError("Pedido sem produtos");
        }

        if (e.hasErrors()) {
            throw e;
        }
    }
}
