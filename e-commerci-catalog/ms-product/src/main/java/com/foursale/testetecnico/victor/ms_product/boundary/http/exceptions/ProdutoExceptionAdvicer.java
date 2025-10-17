package com.foursale.testetecnico.victor.ms_product.boundary.http.exceptions;

import com.foursale.testetecnico.victor.ms_product.core.exception.CriarProdutoException;
import com.foursale.testetecnico.victor.ms_product.core.exception.RemoverProdutoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ProdutoExceptionAdvicer {

    @ExceptionHandler(CriarProdutoException.class)
    public ResponseEntity<Map<String, Object>> handlerCriarProduto(CriarProdutoException e) {
        Map<String, Object> erros = new HashMap<>();

        erros.put("mensagem-principal", e.getMessage());
        erros.put("detalhes", e.getErros());

        return ResponseEntity.badRequest().body(erros);
    }

    @ExceptionHandler(RemoverProdutoException.class)
    public ResponseEntity<Map<String, Object>> handlerRemoverProduto(RemoverProdutoException e) {
        Map<String, Object> erros = new HashMap<>();

        erros.put("mensagem-principal", e.getMessage());

        return ResponseEntity.badRequest().body(erros);
    }
}
