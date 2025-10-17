package com.foursale.testetecnico.victor.ms_product.core.application;

import com.foursale.testetecnico.victor.ms_product.core.application.ports.EnviarMensagemEstoque;
import com.foursale.testetecnico.victor.ms_product.core.application.ports.EnviarMensagemProduto;
import com.foursale.testetecnico.victor.ms_product.core.application.ports.ProdutoRepository;
import com.foursale.testetecnico.victor.ms_product.core.exception.RemoverProdutoException;
import com.foursale.testetecnico.victor.ms_product.core.model.OperacaoEstoque;
import com.foursale.testetecnico.victor.ms_product.core.model.OperacaoProduto;
import com.foursale.testetecnico.victor.ms_product.core.model.Produto;
import com.foursale.testetecnico.victor.ms_product.helpers.model.ProdutoHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RemoverProdutoUserCaseTest {

    @InjectMocks
    private RemoverProdutoUserCase userCase;

    @Mock
    private ProdutoRepository produtoRepository;

    @Mock
    private EnviarMensagemProduto enviarMensagemProduto;

    @Mock
    private EnviarMensagemEstoque enviarMensagemEstoque;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testDeveRemoverComSucesso() {
        Produto produto = ProdutoHelper.getBasico();

        userCase.remover(produto);

        verify(produtoRepository).remover(produto);
        verify(enviarMensagemProduto).enviar(produto, OperacaoProduto.REMOCAO);
        verify(enviarMensagemEstoque).enviar(produto, OperacaoEstoque.REMOVER);
    }

    @Test
    void testNaoDeveRemover() {
        Produto produto = ProdutoHelper.getBasico();

        when(produtoRepository.exists(Mockito.any()))
                .thenThrow(RemoverProdutoException.class);

        Assertions.assertThrows(RemoverProdutoException.class, () -> {
            userCase.remover(produto);
        });
    }
}