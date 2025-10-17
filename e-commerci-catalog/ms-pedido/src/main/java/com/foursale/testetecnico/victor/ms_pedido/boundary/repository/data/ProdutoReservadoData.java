package com.foursale.testetecnico.victor.ms_pedido.boundary.repository.data;

import com.foursale.testetecnico.victor.ms_pedido.core.model.Categoria;
import com.foursale.testetecnico.victor.ms_pedido.core.model.Pedido;
import com.foursale.testetecnico.victor.ms_pedido.core.model.Produto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table("tb_produto_reservado")
@NoArgsConstructor
public class ProdutoReservadoData {

    @Id
    private UUID id;

    private Double preco;

    private String nome;
    private String descricao;
    private String nomeCategoria;

    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    public ProdutoReservadoData(Produto produto) {
        this.id = produto.getId();
        this.preco = produto.getPreco();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.nomeCategoria = produto.getCategoria().getNome();
        this.dataAtualizacao = produto.getDataAtualizacao();
        this.dataCriacao = produto.getDataCriacao();
    }

    public Produto toModel() {
        Produto produto = new Produto();
        produto.setId(this.id);
        produto.setPreco(this.preco);
        produto.setNome(this.nome);
        produto.setDescricao(this.descricao);
        produto.setCategoria(new Categoria());
        produto.getCategoria().setNome(this.nomeCategoria);
        produto.setDataAtualizacao(this.dataAtualizacao);
        produto.setDataCriacao(this.dataCriacao);
        return produto;
    }
}
