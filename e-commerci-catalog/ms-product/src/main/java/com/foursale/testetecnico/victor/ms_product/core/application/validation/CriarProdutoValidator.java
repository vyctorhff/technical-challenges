package com.foursale.testetecnico.victor.ms_product.core.application.validation;

import com.foursale.testetecnico.victor.ms_product.core.exception.CriarProdutoException;
import com.foursale.testetecnico.victor.ms_product.core.exception.ApplicationException;
import com.foursale.testetecnico.victor.ms_product.core.model.Produto;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * Classe para validação das regras de negócio da entendi.
 *
 * OBS: optei por não usar o spring validation para deixar as regras
 * nas camasda de negócio(core).
 */
@RequiredArgsConstructor
public class CriarProdutoValidator {

    public void validar(Produto produto) throws CriarProdutoException {
        CriarProdutoException e = new CriarProdutoException("Falhar ao criar o produto");

        if (produto == null) {
            e.addError("Produto invalido");

        } else if (StringUtils.isBlank(produto.getNome())) {
            e.addError("Nome do produto invalido");

        } else if (produto.getPreco() == null || produto.getPreco() <= 0.0) {
            e.addError("Preço não definido");
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
            e.addError("Categoria invalida");
        } else if (StringUtils.isBlank(produto.getCategoria().getNome())) {
            e.addError("Nome da categoria invalida");
        }
    }

    private void validateEstoque(Produto produto, ApplicationException e) {
        if (produto.getEstoque() == null) {
            e.addError("Estoque invalido");
        } else if (produto.getEstoque().getQuantidade() < 0) {
            e.addError("Quantidade do estoque invalido");
        }
    }
}
