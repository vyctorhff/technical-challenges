package com.foursale.testetecnico.victor.ms_product.boundary.auth;

import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    private Integer id;

    private String name;

    private List<User> users;

    public Role(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .build();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Role role) {
            return new EqualsBuilder()
                    .append(this.name, role.getName())
                    .isEquals();
        }

        return false;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.name)
                .hashCode();
    }
}
