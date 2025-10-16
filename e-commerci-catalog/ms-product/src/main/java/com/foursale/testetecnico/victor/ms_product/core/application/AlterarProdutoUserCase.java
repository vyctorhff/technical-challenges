package com.foursale.testetecnico.victor.ms_product.core.application;

import com.foursale.testetecnico.victor.ms_product.core.application.ports.EnviarMensagemEstoque;
import com.foursale.testetecnico.victor.ms_product.core.application.ports.EnviarMensagemProduto;
import com.foursale.testetecnico.victor.ms_product.core.application.ports.ProdutoRepository;
import com.foursale.testetecnico.victor.ms_product.core.application.validation.CriarProdutoValidator;
import com.foursale.testetecnico.victor.ms_product.core.exception.CriarProdutoValidatiorException;
import com.foursale.testetecnico.victor.ms_product.core.exception.EnviarProdutoException;
import com.foursale.testetecnico.victor.ms_product.core.model.OperacaoEstoque;
import com.foursale.testetecnico.victor.ms_product.core.model.OperacaoProduto;
import com.foursale.testetecnico.victor.ms_product.core.model.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class AlterarProdutoUserCase {

    private final CriarProdutoValidator validatior;

    private final ProdutoRepository produtoRepository;

    private final EnviarMensagemProduto enviarMensagemProduto;

    private final EnviarMensagemEstoque enviarMensagemEstoque;

    public void alterar(Produto produto) throws CriarProdutoValidatiorException, EnviarProdutoException {
        validatior.validar(produto);

        log.info("Criando produto");
        produtoRepository.salvar(produto);

        log.info("Enviando mensagem produto novo");
        enviarMensagemProduto.enviar(produto, OperacaoProduto.ATUALIZACAO);

        log.info("Enviando mensagem alterar estoque");
        enviarMensagemEstoque.enviar(produto, OperacaoEstoque.ATUALIZAR);
    }
}
