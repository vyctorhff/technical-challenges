package com.foursale.testetecnico.victor.ms_product.helpers.model;

import com.foursale.testetecnico.victor.ms_product.core.model.Categoria;

import java.time.LocalDateTime;

public final class CategoriaHelper {

    public static Categoria getBasico() {
        Categoria categoria = new Categoria();
        categoria.setNome("nome");
        categoria.setDataCriacao(LocalDateTime.now());
        categoria.setDataAtualizacao(LocalDateTime.now());
        return categoria;
    }
}
