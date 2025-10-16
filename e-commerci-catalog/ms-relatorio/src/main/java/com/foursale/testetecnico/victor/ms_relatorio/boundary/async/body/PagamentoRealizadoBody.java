package com.foursale.testetecnico.victor.ms_relatorio.boundary.async.body;

import com.foursale.testetecnico.victor.ms_relatorio.core.model.PedidoRelatorio;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record PagamentoRealizadoBody (
        UUID id,
        PagamentoBody pagamento,
        UsuarioBody usuario,
        Double total,
        LocalDateTime dataPedido,
        LocalDateTime dataPagamento
) {
    public PedidoRelatorio toModel() {
        PedidoRelatorio pedidoRelatorio = new PedidoRelatorio();
        pedidoRelatorio.setId(id);
        pedidoRelatorio.setTotal(BigDecimal.valueOf(total));
        pedidoRelatorio.setUsuario(usuario.toModel());
        pedidoRelatorio.setPagamento(pagamento.toModel());
        pedidoRelatorio.setDataPedido(dataPedido);
        pedidoRelatorio.setDataPagamento(dataPagamento);
        return pedidoRelatorio;
    }
}
