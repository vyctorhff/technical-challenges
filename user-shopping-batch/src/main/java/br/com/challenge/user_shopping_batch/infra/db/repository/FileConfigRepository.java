package br.com.challenge.user_shopping_batch.infra.db.repository;

import br.com.challenge.user_shopping_batch.infra.db.entity.FileConfigEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileConfigRepository extends CrudRepository<FileConfigEntity, Long> {
}
