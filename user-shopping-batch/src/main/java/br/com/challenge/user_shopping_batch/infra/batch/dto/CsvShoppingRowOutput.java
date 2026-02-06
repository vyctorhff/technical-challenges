package br.com.challenge.user_shopping_batch.infra.batch.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CsvShoppingRowOutput(
        Long idFile,
        String name,
        String detail,
        BigDecimal amount,
        LocalDateTime date
) {

    public String fullRow() {
        return String.join(";", idFile.toString(), name, amount.toString(), date.toString());
    }
}
