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
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.descricao = produto.getDescricao();
        this.dataCriacao = produto.getDataCriacao();
        this.dataAtualizacao = produto.getDataAtualizacao();

        estoque = new EstoqueData(produto.getEstoque());
        categoria = new CategoriaData(produto.getCategoria());
    }

    public Produto toModel() {
        Produto produto = new Produto();
        produto.setId(this.id);
        produto.setNome(this.nome);
        produto.setPreco(this.preco);
        produto.setDescricao(this.descricao);
        produto.setDataCriacao(this.dataCriacao);
        produto.setDataAtualizacao(this.dataAtualizacao);

        produto.setCategoria(categoria.toModel());
        produto.setEstoque(estoque.toModel());
        return produto;
    }
}
