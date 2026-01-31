package br.com.challenge.user_shopping_batch.infra.db.repository;

import br.com.challenge.user_shopping_batch.infra.db.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    List<UserEntity> findByEnable(Boolean enable);
}
