package com.foursale.testetecnico.victor.ms_auth.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    private UUID id;

    private String pass;

    private String nome;

    private String email;

    private String cpf;

    private List<Perfil> roles;

    public boolean hasRoles() {
        return roles != null && !roles.isEmpty();
    }

    public boolean hasAdminRole() {
        return hasRoles() && roles.stream()
                .anyMatch(role -> PerfilEnum.hasAdminName(role.getNome()));
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", nome)
                .build();
    }
}

