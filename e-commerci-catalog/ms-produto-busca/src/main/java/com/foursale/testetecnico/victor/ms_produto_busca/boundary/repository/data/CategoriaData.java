package com.foursale.testetecnico.victor.ms_produto_busca.boundary.repository.data;

import com.foursale.testetecnico.victor.ms_produto_busca.core.model.Categoria;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
public class CategoriaData {

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
