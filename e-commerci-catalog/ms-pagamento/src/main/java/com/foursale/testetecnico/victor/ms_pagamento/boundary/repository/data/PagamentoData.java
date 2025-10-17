package com.foursale.testetecnico.victor.ms_pagamento.boundary.repository.data;

import com.foursale.testetecnico.victor.ms_pagamento.core.model.Carteira;
import com.foursale.testetecnico.victor.ms_pagamento.core.model.FormaPagamento;
import com.foursale.testetecnico.victor.ms_pagamento.core.model.Pagamento;
import com.foursale.testetecnico.victor.ms_pagamento.core.model.Pedido;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@Table("tb_pagamento")
public class PagamentoData {
    @Id
    private UUID id;

    private Double total;

    private LocalDateTime dataPedido;
    private LocalDateTime dataPagamento;

    private FormaPagamentoData formaPagamento;

    private CarteiraData carteira;
    private PedidoData pedido;

    public PagamentoData(Pagamento pagamento) {
        this.id = pagamento.getId();
        this.total = pagamento.getTotal();
        this.dataPedido = pagamento.getDataPedido();
        this.dataPagamento = pagamento.getDataPagamento();

        this.formaPagamento = new FormaPagamentoData(pagamento.getFormaPagamento());
        this.pedido = new PedidoData(pagamento.getPedido());
    }

    public Pagamento toModel() {
        Pagamento pagamento = new Pagamento();
        return pagamento;
    }
}
