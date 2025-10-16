package com.foursale.testetecnico.victor.ms_product.core.application.validation;

import com.foursale.testetecnico.victor.ms_product.core.exception.CriarProdutoValidatiorException;
import com.foursale.testetecnico.victor.ms_product.core.exception.ApplicationException;
import com.foursale.testetecnico.victor.ms_product.core.model.Produto;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@RequiredArgsConstructor
public class CriarProdutoValidator {

    // TODO: fazer

    public void validar(Produto produto) throws CriarProdutoValidatiorException {
        CriarProdutoValidatiorException e = new CriarProdutoValidatiorException("Falhar ao criar o produto");

        if (produto == null) {
            e.addError("");
        } else if (StringUtils.isBlank(produto.getNome())) {
            e.addError("");
        } else if (produto.getPreco() == null || produto.getPreco() <= 0.0) {
            e.addError("");
        }

        if (produto != null) {
            validateEstoque(produto, e);
            validateCategoria(produto, e);
        }

        if (e.hasErrors()) {
            throw e;
        }
    }

    private void validateCategoria(Produto produto, ApplicationException e) {
        if (produto.getCategoria() == null) {
            e.addError("");
        } else if (StringUtils.isBlank(produto.getCategoria().getNome())) {
            e.addError("");
        }
    }

    private void validateEstoque(Produto produto, ApplicationException e) {
        if (produto.getEstoque() == null) {
            e.addError("");
        } else if (produto.getEstoque().getQuantidade() < 0) {
            e.addError("");
        }
    }
}
