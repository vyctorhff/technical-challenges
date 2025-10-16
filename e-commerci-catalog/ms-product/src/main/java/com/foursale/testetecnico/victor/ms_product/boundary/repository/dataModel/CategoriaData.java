package com.foursale.testetecnico.victor.ms_product.boundary.repository.dataModel;

import com.foursale.testetecnico.victor.ms_product.core.model.Categoria;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@Table("tb_categoria")
@NoArgsConstructor
public class CategoriaData {

    @Id
    private UUID id;

    private String nome;

    public CategoriaData(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

    public Categoria toModel() {
        Categoria categoria = new Categoria();
        categoria.setId(this.id);
        categoria.setNome(this.nome);
        return categoria;
    }
}
