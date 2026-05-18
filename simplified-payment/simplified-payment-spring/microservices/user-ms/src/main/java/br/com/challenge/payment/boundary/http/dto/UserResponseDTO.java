package br.com.challenge.payment.boundary.http.dto;

import br.com.challenge.payment.boundary.repository.entity.User;

public record UserResponseDTO(
        Integer id,
        String externalId,
        String name,
        String cpf,
        String cnpj,
        AccountResponseDTO account
) {
    public static UserResponseDTO fromUser(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getExternalId(),
                user.getName(),
                user.getCpf(),
                user.getCnpj(),
                AccountResponseDTO.fromAccount(user.getAccount())
        );
    }
}
