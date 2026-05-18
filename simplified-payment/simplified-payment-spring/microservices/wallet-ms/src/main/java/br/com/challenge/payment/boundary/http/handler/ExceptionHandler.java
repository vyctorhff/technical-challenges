package br.com.challenge.payment.boundary.http.handler;

import br.com.challenge.payment.boundary.http.dto.ErrorHandlerDTO;
import br.com.challenge.payment.core.exception.ApplicationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErrorHandlerDTO> handler(ApplicationException e) {
        ErrorHandlerDTO body = ErrorHandlerDTO.create(e);
        return ResponseEntity.internalServerError().body(body);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorHandlerDTO> handlerException(Exception e) {
        ErrorHandlerDTO body = ErrorHandlerDTO.create(e);
        return ResponseEntity.internalServerError().body(body);
    }
}
