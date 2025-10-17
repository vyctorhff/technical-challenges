package com.foursale.testetecnico.victor.ms_auth.boundary.repository.dataModel;

import com.foursale.testetecnico.victor.ms_auth.core.model.Perfil;
import com.foursale.testetecnico.victor.ms_auth.core.model.PerfilEnum;
import com.foursale.testetecnico.victor.ms_auth.core.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Table("tb_usuario")
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioData {

    @Id
    private UUID id;

    private String nome;

    private String password;

    private String email;

    private String cpf;

    @MappedCollection(keyColumn = "id", idColumn = "id_usuario")
    private Set<UsuarioPerfilData> perfils2;

    private List<PerfilData> perfis;

    public boolean hasRoles() {
        return perfis != null && !perfis.isEmpty();
    }

    public boolean hasAdminRole() {
        return hasRoles() && perfis.stream()
                .anyMatch(role -> PerfilEnum.hasAdminName(role.getNome()));
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", nome)
                .build();
    }

    public Usuario toModel() {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNome(nome);
        usuario.setPass(password);
        usuario.setRoles(perfis.stream().map(PerfilData::toModel).toList());
        return usuario;
    }
}

