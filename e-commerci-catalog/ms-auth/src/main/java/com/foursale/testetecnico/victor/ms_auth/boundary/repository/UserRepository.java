package com.foursale.testetecnico.victor.ms_auth.boundary.repository;

import com.foursale.testetecnico.victor.ms_auth.boundary.repository.dataModel.UsuarioData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<UsuarioData, UUID> {

    UsuarioData findByNome(String nome);
}
