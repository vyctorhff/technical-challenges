package com.foursale.testetecnico.victor.ms_relatorio.boundary.repository.spring.data;

import com.foursale.testetecnico.victor.ms_relatorio.core.model.Pagamento;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@Table("tb_pagamento")
@NoArgsConstructor
public class PagamentoData {

    @Id
    private UUID id;

    public PagamentoData(Pagamento pagamento) {
        this.id = pagamento.getId();
    }

    public Pagamento toModel() {
        Pagamento pagamento = new Pagamento();
        pagamento.setId(id);
        return pagamento;
    }
}
