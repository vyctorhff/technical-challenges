package com.foursale.testetecnico.victor.ms_relatorio.boundary.security.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
public class UserAuthentication implements UserDetails {

    private Usuario user;

    public UserAuthentication(Usuario user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (PerfilEnum.ADMIN.getName().equals(user.getName())) {
            return List.of(
                    new SimpleGrantedAuthority("admin")
            );
        }

        return List.of(
                new SimpleGrantedAuthority("user")
        );
    }

    @Override
    public String getPassword() {
        return user.getPass();
    }

    @Override
    public String getUsername() {
        return String.valueOf(user.getName());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
