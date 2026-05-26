package br.com.challenge.payment.boundary.repository;

import br.com.challenge.payment.boundary.repository.entity.WalletEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends CrudRepository<WalletEntity, Integer> {
}
