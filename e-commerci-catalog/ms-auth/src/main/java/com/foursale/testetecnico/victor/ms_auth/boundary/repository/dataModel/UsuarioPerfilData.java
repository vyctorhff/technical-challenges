package com.foursale.testetecnico.victor.ms_auth.boundary.repository.dataModel;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("tb_usuario_perfil")
public class UsuarioPerfilData {

    @Id
    private UUID id;

    private UUID idUsuario;

    private UUID idPerfil;
}
