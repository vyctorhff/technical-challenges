package com.foursale.testetecnico.victor.ms_product.boundary.repository.dataModel;

import com.foursale.testetecnico.victor.ms_product.core.model.Produto;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Table("tb_produto")
@NoArgsConstructor
public class ProdutoData {

    @Id
    private UUID id;

    private Double preco;

    private String nome;
    private String descricao;

    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    private CategoriaData categoria;
    private EstoqueData estoque;

    public ProdutoData(Produto produto) {
        categoria = new CategoriaData(produto.getCategoria());
        estoque = new EstoqueData(produto.getEstoque());
    }

    public Produto toModel() {
        Produto produto = new Produto();
        produto.setCategoria(categoria.toModel());
        produto.setEstoque(estoque.toModel());
        return produto;
    }
}
