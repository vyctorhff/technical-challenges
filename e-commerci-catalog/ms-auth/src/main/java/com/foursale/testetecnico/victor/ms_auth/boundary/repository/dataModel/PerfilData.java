package com.foursale.testetecnico.victor.ms_auth.boundary.repository.dataModel;

import com.foursale.testetecnico.victor.ms_auth.core.model.Perfil;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@Table("tb_perfil")
@NoArgsConstructor
public class PerfilData {
    @Id
    private UUID id;

    private String nome;

    public Perfil toModel() {
        Perfil perfil = new Perfil();
        perfil.setId(id);
        perfil.setNome(nome);
        return perfil;
    }
}
