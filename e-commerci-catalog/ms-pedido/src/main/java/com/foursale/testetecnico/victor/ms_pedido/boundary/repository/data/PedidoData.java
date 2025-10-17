package com.foursale.testetecnico.victor.ms_pedido.boundary.repository.data;

import com.foursale.testetecnico.victor.ms_pedido.core.model.Pedido;
import com.foursale.testetecnico.victor.ms_pedido.core.model.PedidoStatus;
import com.foursale.testetecnico.victor.ms_pedido.core.model.Produto;
import com.foursale.testetecnico.victor.ms_pedido.core.model.Usuario;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Table("tb_pedido")
@NoArgsConstructor
public class PedidoData {

    @Id
    private UUID id;

    private PedidoStatus pedidoStatus;

    private Usuario usuario;

    private List<Produto> produtos;

    private LocalDateTime dataCriacao;

    public PedidoData(Pedido pedido) {
        this.id = pedido.getId();
        this.pedidoStatus = pedido.getPedidoStatus();
        this.usuario = pedido.getUsuario();
        this.produtos = pedido.getProdutos();
        this.dataCriacao = pedido.getDataCriacao();
    }

    public Pedido toModel() {
        Pedido pedido = new Pedido();
        pedido.setId(this.id);
        pedido.setPedidoStatus(this.pedidoStatus);
        pedido.setUsuario(this.usuario);
        pedido.setProdutos(this.produtos);
        pedido.setDataCriacao(this.dataCriacao);
        return pedido;
    }
}
