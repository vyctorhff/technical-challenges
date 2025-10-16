package com.foursale.testetecnico.victor.ms_product.core.application;

import com.foursale.testetecnico.victor.ms_product.core.application.ports.EnviarMensagemEstoque;
import com.foursale.testetecnico.victor.ms_product.core.application.ports.EnviarMensagemProduto;
import com.foursale.testetecnico.victor.ms_product.core.application.ports.ProdutoRepository;
import com.foursale.testetecnico.victor.ms_product.core.exception.EnviarProdutoException;
import com.foursale.testetecnico.victor.ms_product.core.exception.RemoverProdutoException;
import com.foursale.testetecnico.victor.ms_product.core.model.OperacaoEstoque;
import com.foursale.testetecnico.victor.ms_product.core.model.OperacaoProduto;
import com.foursale.testetecnico.victor.ms_product.core.model.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class RemoverProdutoUserCase {

    private final ProdutoRepository produtoRepository;

    private final EnviarMensagemProduto enviarMensagemProduto;

    private final EnviarMensagemEstoque enviarMensagemEstoque;

    public void remover(Produto produto) throws RemoverProdutoException, EnviarProdutoException {
        // TODO: validar se existe?

        log.info("Removendo produto");
        produtoRepository.remover(produto);

        log.info("Enviando mensagem produto removido");
        enviarMensagemProduto.enviar(produto, OperacaoProduto.REMOCAO);

        log.info("Enviando mensagem remover estoque");
        enviarMensagemEstoque.enviar(produto, OperacaoEstoque.REMOVER);
    }
}
