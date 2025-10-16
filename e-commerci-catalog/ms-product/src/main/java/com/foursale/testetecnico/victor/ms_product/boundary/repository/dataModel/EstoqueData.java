package com.foursale.testetecnico.victor.ms_product.boundary.repository.dataModel;

import com.foursale.testetecnico.victor.ms_product.core.model.Estoque;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@Table("tb_estoque")
@NoArgsConstructor
public class EstoqueData {

    @Id
    private UUID id;

    private Long quantidade;

    public EstoqueData(Estoque estoque) {
    }

    public Estoque toModel() {
        return null;
    }
}
