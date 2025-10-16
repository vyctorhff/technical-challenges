package com.foursale.testetecnico.victor.ms_produto_busca.boundary.repository.data;

import com.foursale.testetecnico.victor.ms_produto_busca.core.model.Produto;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document(indexName = "produtos")
public class ProdutoData {

    @Id
    private UUID id;

    private String nome;
    private String descricao;

    private Double preco;

    private CategoriaData categoria;

    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    public ProdutoData() {}

    public ProdutoData(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.descricao = produto.getDescricao();
        this.dataCriacao = produto.getDataCriacao();
        this.dataAtualizacao = produto.getDataAtualizacao();

        this.categoria = new CategoriaData(produto.getCategoria());
    }

    public Produto toModel() {
        Produto produto = new Produto();
        produto.setId(this.id);
        produto.setNome(this.nome);
        produto.setDescricao(this.descricao);
        produto.setPreco(this.preco);
        produto.setDataCriacao(this.dataCriacao);
        produto.setDataAtualizacao(this.dataAtualizacao);
        produto.setCategoria(categoria.toModel());
        return produto;
    }
}
