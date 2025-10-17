package com.foursale.testetecnico.victor.ms_pedido.core.application;

import com.foursale.testetecnico.victor.ms_pedido.core.application.port.EnviarMensagemPagamento;
import com.foursale.testetecnico.victor.ms_pedido.core.application.port.PedidoRepository;
import com.foursale.testetecnico.victor.ms_pedido.core.application.port.ReservarEstoque;
import com.foursale.testetecnico.victor.ms_pedido.core.application.port.ReservarProduto;
import com.foursale.testetecnico.victor.ms_pedido.core.application.validator.CriarPedidoValidador;
import com.foursale.testetecnico.victor.ms_pedido.core.model.OperacaoPagamento;
import com.foursale.testetecnico.victor.ms_pedido.core.model.Pedido;
import com.foursale.testetecnico.victor.ms_pedido.core.model.PedidoStatus;
import com.foursale.testetecnico.victor.ms_pedido.helpers.model.PedidoHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CriarPedidoUserCaseTest {

    @InjectMocks
    private CriarPedidoUserCase userCase;

    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private ReservarProduto reservarProduto;

    @Mock
    private ReservarEstoque reservarEstoque;

    @Mock
    private EnviarMensagemPagamento enviarMensagemPagamento;

    @Mock
    private CriarPedidoValidador validador;

    @Test
    void testDeveCriarPedidoComSucesso() {
        Pedido pedido = PedidoHelper.getCriar();

        Mockito.when(reservarEstoque.reservar(pedido))
                .thenReturn(Boolean.TRUE);

        userCase.criar(pedido);

        assertEquals(PedidoStatus.PENDENTE, pedido.getPedidoStatus());
        assertNotNull(pedido.getDataCriacao());

        verify(pedidoRepository).salvar(pedido);
        verify(reservarProduto).reservar(pedido);
        verify(reservarEstoque).reservar(pedido);
        verify(enviarMensagemPagamento).enviar(pedido, OperacaoPagamento.CRIACAO);
        verify(validador).validar(pedido);
    }

    @Test
    void testDeveCancelarPedidoQuandoSemEstoque() {
        Pedido pedido = PedidoHelper.getCriar();

        Mockito.when(reservarEstoque.reservar(pedido))
                .thenReturn(Boolean.FALSE);

        userCase.criar(pedido);

        assertEquals(PedidoStatus.CANCELADO, pedido.getPedidoStatus());
        assertNotNull(pedido.getDataCriacao());

        verify(pedidoRepository).salvar(pedido);
        verify(reservarProduto).reservar(pedido);
        verify(reservarEstoque).reservar(pedido);
        verify(enviarMensagemPagamento).enviar(pedido, OperacaoPagamento.CRIACAO);
        verify(validador).validar(pedido);
    }
}