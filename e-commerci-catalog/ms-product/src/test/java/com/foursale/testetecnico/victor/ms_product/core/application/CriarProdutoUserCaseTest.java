package com.foursale.testetecnico.victor.ms_product.core.application;

import com.foursale.testetecnico.victor.ms_product.core.application.ports.EnviarMensagemEstoque;
import com.foursale.testetecnico.victor.ms_product.core.application.ports.EnviarMensagemProduto;
import com.foursale.testetecnico.victor.ms_product.core.application.ports.ProdutoRepository;
import com.foursale.testetecnico.victor.ms_product.core.application.validation.CriarProdutoValidator;
import com.foursale.testetecnico.victor.ms_product.core.model.OperacaoEstoque;
import com.foursale.testetecnico.victor.ms_product.core.model.OperacaoProduto;
import com.foursale.testetecnico.victor.ms_product.core.model.Produto;
import com.foursale.testetecnico.victor.ms_product.helpers.model.ProdutoHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CriarProdutoUserCaseTest {

    @InjectMocks
    private CriarProdutoUserCase userCase;

    @Mock
    private CriarProdutoValidator validatior;

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
    void testDeveCriarProdutoComSucesso() {
        Produto produto = ProdutoHelper.GetSemDatas();

        this.userCase.criar(produto);

        verify(validatior).validar(produto);
        verify(produtoRepository).salvar(produto);
        verify(enviarMensagemProduto).enviar(produto, OperacaoProduto.CRIACAO);
        verify(enviarMensagemEstoque).enviar(produto, OperacaoEstoque.CRIAR);
    }
}