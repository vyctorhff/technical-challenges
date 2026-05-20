package br.com.challenge.payment.boundary.http.dto;

public record TransferResponseDTO(
        Integer payer,
        Integer payee,
        Double value
) {
}
