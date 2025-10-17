package com.foursale.testetecnico.victor.ms_relatorio.boundary.repository.spring.data;

import com.foursale.testetecnico.victor.ms_relatorio.core.model.PedidoRelatorio;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table("tb_pedido_relatorio")
@NoArgsConstructor
public class PedidoData {

    @Id
    private UUID id;

    private Double total;

    private LocalDateTime dataPedido;

    private LocalDateTime dataPagamento;

    private UsuarioData usuario;

    private PagamentoData pagamento;

    public PedidoData(PedidoRelatorio pedidoRelatorio) {
        this.id = pedidoRelatorio.getId();
        this.total = pedidoRelatorio.getTotal().doubleValue();
        this.dataPedido = pedidoRelatorio.getDataPedido();
        this.dataPagamento = pedidoRelatorio.getDataPagamento();
        this.usuario = new UsuarioData(pedidoRelatorio.getUsuario());
        this.pagamento = new PagamentoData(pedidoRelatorio.getPagamento());
    }

    public PedidoRelatorio toModel() {
        PedidoRelatorio pedido = new PedidoRelatorio();
        pedido.setId(id);
        pedido.setTotal(BigDecimal.valueOf(total));
        pedido.setDataPedido(dataPedido);
        pedido.setDataPagamento(dataPagamento);
        pedido.setUsuario(usuario.toModel());
        pedido.setPagamento(pagamento.toModel());
        return pedido;
    }
}
