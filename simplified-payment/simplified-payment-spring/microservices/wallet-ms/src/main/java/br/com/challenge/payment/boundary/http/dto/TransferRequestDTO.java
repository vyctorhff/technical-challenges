package br.com.challenge.payment.boundary.http.dto;

import java.time.LocalDateTime;

public record TransferRequestDTO(
        String status,
        String transactionHash,
        LocalDateTime data
) {
}
