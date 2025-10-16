package com.foursale.testetecnico.victor.ms_produto_busca.boundary.security.repository;

import com.foursale.testetecnico.victor.ms_produto_busca.boundary.security.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Usuario, String> {

    Usuario findByEnrollment(Integer enrollment);
}
