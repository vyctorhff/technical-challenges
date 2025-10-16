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
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Table("tb_user")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioData {

    @Id
    private String id;

    private String matricula;

    private String pass;

    private String name;

    private LocalDateTime createdAt;

    private List<Perfil> perfis;

    public boolean hasRoles() {
        return perfis != null && !perfis.isEmpty();
    }

    public boolean hasAdminRole() {
        return hasRoles() && perfis.stream()
                .anyMatch(role -> PerfilEnum.hasAdminName(role.getName()));
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .build();
    }

    public Usuario toModel() {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setName(name);
        usuario.setPass(pass);
        usuario.setRoles(perfis);
        return usuario;
    }
}

