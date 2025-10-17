package com.foursale.testetecnico.victor.ms_pedido.boundary.http.exception;

import com.foursale.testetecnico.victor.ms_pedido.core.exception.ApplicationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ProdutoExceptionAdvicer {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<Map<String, Object>> handlerCriarProduto(ApplicationException e) {
        Map<String, Object> erros = new HashMap<>();

        erros.put("mensagem-principal", e.getMessage());
        erros.put("detalhes", e.getErros());

        return ResponseEntity.badRequest().body(erros);
    }
}
