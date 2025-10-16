package com.foursale.testetecnico.victor.ms_auth.boundary.repository;

import com.foursale.testetecnico.victor.ms_auth.boundary.repository.dataModel.UsuarioData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UsuarioData, String> {

    UsuarioData findByMatricula(Integer matricula);
}
