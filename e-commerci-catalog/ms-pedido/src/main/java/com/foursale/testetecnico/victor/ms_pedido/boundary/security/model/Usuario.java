package com.foursale.testetecnico.victor.ms_pedido.boundary.security.model;

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
public class Usuario {

    @Id
    private String id;

    private String enrollment;

    private String pass;

    private String name;

    private LocalDateTime createdAt;

    private List<Perfil> roles;

    public boolean hasRoles() {
        return roles != null && !roles.isEmpty();
    }

    public boolean hasAdminRole() {
        return hasRoles() && roles.stream()
                .anyMatch(role -> PerfilEnum.hasAdminName(role.getName()));
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .build();
    }
}

