package com.foursale.testetecnico.victor.ms_relatorio.boundary.repository.spring.data;

import com.foursale.testetecnico.victor.ms_relatorio.core.model.Usuario;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@Table("tb_usuario")
@NoArgsConstructor
public class UsuarioData {

    @Id
    private UUID id;

    private String nome;

    public UsuarioData(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
    }

    public Usuario toModel() {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNome(nome);
        return usuario;
    }
}
