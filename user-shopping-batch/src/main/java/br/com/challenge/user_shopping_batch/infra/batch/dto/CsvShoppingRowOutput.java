package br.com.challenge.user_shopping_batch.infra.batch.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CsvShoppingRowOutput(
        String name,
        String detail,
        BigDecimal amount,
        LocalDateTime date
) {
}
