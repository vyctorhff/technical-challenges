package br.com.challenge.user_shopping_batch.infra.batch.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CsvShoppingRowInput(
        String name,
        String shoppingDetail,
        BigDecimal amount,
        LocalDateTime date
) {
}
