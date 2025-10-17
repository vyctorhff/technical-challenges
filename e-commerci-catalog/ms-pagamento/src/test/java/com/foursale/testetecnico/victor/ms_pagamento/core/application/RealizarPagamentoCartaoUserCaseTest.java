package com.foursale.testetecnico.victor.ms_pagamento.core.application;

import com.foursale.testetecnico.victor.ms_pagamento.core.application.port.ConfirmarPagamentoCartao;
import com.foursale.testetecnico.victor.ms_pagamento.core.application.port.EnviarMensagemPagamentoRelatorio;
import com.foursale.testetecnico.victor.ms_pagamento.core.application.port.EnviarMensagemPedidoPago;
import com.foursale.testetecnico.victor.ms_pagamento.core.application.port.PagamentoRepository;
import com.foursale.testetecnico.victor.ms_pagamento.core.exception.RealizarPagamentoCartaoException;
import com.foursale.testetecnico.victor.ms_pagamento.core.model.Pagamento;
import com.foursale.testetecnico.victor.ms_pagamento.core.model.PagamentoStatus;
import com.foursale.testetecnico.victor.ms_pagamento.helpers.model.PagamentoHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.actuate.metrics.export.prometheus.PrometheusPushGatewayManager;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RealizarPagamentoCartaoUserCaseTest {

    @InjectMocks
    private RealizarPagamentoCartaoUserCase userCase;

    @Mock
    private ConfirmarPagamentoCartao confirmarPagamentoCartao;

    @Mock
    private EnviarMensagemPedidoPago enviarMensagemPedidoPago;

    @Mock
    private EnviarMensagemPagamentoRelatorio enviarMensagemPagamentoRelatorio;

    @Mock
    private PagamentoRepository pagamentoRepository;

    @Test
    void testRealizarPagamentoComSucesso() {
        Pagamento pagamento = PagamentoHelper.getRealizarPagamento();

        when(pagamentoRepository.buscarPorId(pagamento.getId()))
                .thenReturn(pagamento);

        userCase.pagar(pagamento);

        assertEquals(PagamentoStatus.PAGO, pagamento.getStatus());
        Assertions.assertNotNull(pagamento.getDataPagamento());

        verify(pagamentoRepository).buscarPorId(pagamento.getId());
        verify(pagamentoRepository).salvar(pagamento);
        verify(confirmarPagamentoCartao).confirmar(pagamento.getCarteira(), pagamento.getTotal());
        verify(enviarMensagemPedidoPago).enviar(pagamento.getPedido());
        verify(enviarMensagemPagamentoRelatorio).enviar(pagamento);
    }

    @Test
    void testPagamentoNaoConfirmadoPelaAdquirente() {
        Pagamento pagamento = PagamentoHelper.getRealizarPagamento();

        when(pagamentoRepository.buscarPorId(pagamento.getId()))
                .thenReturn(pagamento);

        doThrow(IllegalArgumentException.class)
                .when(confirmarPagamentoCartao)
                .confirmar(pagamento.getCarteira(), pagamento.getTotal());

        Assertions.assertThrows(RealizarPagamentoCartaoException.class, () -> {
            userCase.pagar(pagamento);
        });
    }
}