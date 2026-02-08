package br.com.challenge.user_shopping_batch.infra.db.repository;

import br.com.challenge.user_shopping_batch.infra.db.entity.FileEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends CrudRepository<FileEntity, Long> {
}
