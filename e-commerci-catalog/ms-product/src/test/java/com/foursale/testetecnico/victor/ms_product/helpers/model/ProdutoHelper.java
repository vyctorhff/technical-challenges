package com.foursale.testetecnico.victor.ms_product.helpers.model;

import com.foursale.testetecnico.victor.ms_product.core.model.Categoria;
import com.foursale.testetecnico.victor.ms_product.core.model.Estoque;
import com.foursale.testetecnico.victor.ms_product.core.model.Produto;

import java.time.LocalDateTime;

public final class ProdutoHelper {

    public static Produto getBasico() {
        Produto produto = new Produto();
        produto.setNome("nome");
        produto.setDescricao("descricao");
        produto.setPreco(20.0);
        produto.setEstoque(new Estoque());
        produto.setCategoria(CategoriaHelper.getBasico());
        produto.setDataCriacao(LocalDateTime.now());
        produto.setDataAtualizacao(LocalDateTime.now());
        return produto;
    }

    public static Produto GetSemDatas() {
        Produto produto = getBasico();
        produto.setDataAtualizacao(null);
        produto.setDataCriacao(null);
        return produto;
    }
}
