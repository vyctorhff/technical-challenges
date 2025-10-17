package com.foursale.testetecnico.victor.ms_pagamento.boundary.repository.data;

import com.foursale.testetecnico.victor.ms_pagamento.core.model.FormaPagamento;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@NoArgsConstructor
@Table("tb_forma_pagamento")
public class FormaPagamentoData {

    @Id
    private UUID id;

    private String nome;

    public FormaPagamentoData(FormaPagamento formaPagamento) {
        this.id = formaPagamento.getId();
        this.nome = formaPagamento.getNome();
    }

    public FormaPagamento toModel() {
        FormaPagamento formaPagamento = new FormaPagamento();
        formaPagamento.setId(this.id);
        formaPagamento.setNome(this.nome);
        return formaPagamento;
    }
}
