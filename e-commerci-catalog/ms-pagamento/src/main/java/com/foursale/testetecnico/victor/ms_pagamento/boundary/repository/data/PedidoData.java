package com.foursale.testetecnico.victor.ms_pagamento.boundary.repository.data;


import com.foursale.testetecnico.victor.ms_pagamento.core.model.Pedido;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@NoArgsConstructor
@Table("tb_pagamento")
public class PedidoData {

    @Id
    private UUID id;

    public PedidoData(Pedido pedido) {
        this.id = pedido.getId();
    }

    public Pedido toModel() {
        Pedido pedido = new Pedido();
        pedido.setId(this.id);
        return pedido;
    }
}
