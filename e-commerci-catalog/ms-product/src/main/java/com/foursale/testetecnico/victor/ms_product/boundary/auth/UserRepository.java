package com.foursale.testetecnico.victor.ms_product.boundary.auth;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    User findByEnrollment(Integer enrollment);
}
