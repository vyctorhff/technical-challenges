package br.com.challenge.payment.boundary.repository;

import br.com.challenge.payment.boundary.repository.entity.TransactionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionEntity, Integer> {
}
