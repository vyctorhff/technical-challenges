package com.foursale.testetecnico.victor.ms_relatorio.boundary.async.body;

import com.foursale.testetecnico.victor.ms_relatorio.core.model.Usuario;

import java.util.UUID;

public record UsuarioBody (
        UUID id,
        String nome
) {
    public Usuario toModel() {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNome(nome);
        return usuario;
    }
}
