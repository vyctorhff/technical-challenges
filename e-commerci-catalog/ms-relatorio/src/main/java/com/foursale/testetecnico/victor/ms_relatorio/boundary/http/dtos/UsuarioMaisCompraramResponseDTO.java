package com.foursale.testetecnico.victor.ms_relatorio.boundary.http.dtos;

import com.foursale.testetecnico.victor.ms_relatorio.boundary.repository.spring.data.PedidoData;

import java.util.UUID;

public record UsuarioMaisCompraramResponseDTO (
        UUID id,
        String nome,
        Double total
) {

    public static UsuarioMaisCompraramResponseDTO fromPedidoData(PedidoData data) {
        return new UsuarioMaisCompraramResponseDTO(
            data.getId(),
            data.getUsuario().getNome(),
            data.getTotal()
        );
    }
}
