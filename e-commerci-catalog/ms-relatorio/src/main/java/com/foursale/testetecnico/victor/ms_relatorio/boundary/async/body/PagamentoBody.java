package com.foursale.testetecnico.victor.ms_relatorio.boundary.async.body;

import com.foursale.testetecnico.victor.ms_relatorio.core.model.Pagamento;

import java.util.UUID;

public record PagamentoBody (
        UUID id
) {
    public Pagamento toModel() {
        Pagamento pagamento = new Pagamento();
        pagamento.setId(id);
        return pagamento;
    }
}
