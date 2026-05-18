package br.com.challenge.payment.boundary.http.dto;

import br.com.challenge.payment.boundary.repository.entity.Account;

public record AccountResponseDTO(String email) {
    public static AccountResponseDTO fromAccount(Account account) {
        return new AccountResponseDTO(account.getEmail());
    }
}
