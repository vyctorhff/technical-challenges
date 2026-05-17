package br.com.challenge.payment.boundary.http.dto;

import br.com.challenge.payment.core.exception.ApplicationException;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorHandlerDTO (
        List<String> errors,
        LocalDateTime date
) {
    public static ErrorHandlerDTO create(ApplicationException e) {
        return new ErrorHandlerDTO(e.getErrors(), LocalDateTime.now());
    }

    public static ErrorHandlerDTO create(Exception e) {
        return new ErrorHandlerDTO(List.of(e.getMessage()), LocalDateTime.now());
    }
}
