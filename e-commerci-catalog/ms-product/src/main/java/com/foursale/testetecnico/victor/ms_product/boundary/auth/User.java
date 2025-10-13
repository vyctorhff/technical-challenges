package com.foursale.testetecnico.victor.ms_product.boundary.auth;

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
public class User {

    @Id
    private String id;

    private String enrollment;

    private String pass;

    private String name;

    private LocalDateTime createdAt;

    private List<Role> roles;

    public boolean hasRoles() {
        return roles != null && !roles.isEmpty();
    }

    public boolean hasAdminRole() {
        return hasRoles() && roles.stream()
                .anyMatch(role -> Roles.hasAdminName(role.getName()));
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .build();
    }
}

