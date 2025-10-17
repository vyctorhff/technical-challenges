package com.foursale.testetecnico.victor.ms_product.core.exception;

import java.util.ArrayList;
import java.util.List;

public class ApplicationException extends RuntimeException {

    private List<String> erros;

    public ApplicationException(String message) {
        super(message);
        this.erros = new ArrayList<>();
    }

    public void addError(String error) {
        this.erros.add(error);
    }

    public boolean hasErrors() {
        return !this.erros.isEmpty();
    }

    public List<String> getErros() {
        return erros;
    }
}
