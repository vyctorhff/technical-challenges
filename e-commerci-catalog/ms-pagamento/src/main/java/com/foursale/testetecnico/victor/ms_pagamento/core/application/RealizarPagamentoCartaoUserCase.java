package com.foursale.testetecnico.victor.ms_pagamento.core.application;

import com.foursale.testetecnico.victor.ms_pagamento.core.application.port.ConfirmarPagamentoCartao;
import com.foursale.testetecnico.victor.ms_pagamento.core.application.port.EnviarMensagemPagamentoRelatorio;
import com.foursale.testetecnico.victor.ms_pagamento.core.application.port.EnviarMensagemPedidoPago;
import com.foursale.testetecnico.victor.ms_pagamento.core.application.port.PagamentoRepository;
import com.foursale.testetecnico.victor.ms_pagamento.core.exception.RealizarPagamentoCartaoException;
import com.foursale.testetecnico.victor.ms_pagamento.core.model.Pagamento;
import com.foursale.testetecnico.victor.ms_pagamento.core.model.PagamentoStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
public class RealizarPagamentoCartaoUserCase {

    private final ConfirmarPagamentoCartao confirmarPagamentoCartao;

    private final EnviarMensagemPedidoPago enviarMensagemPedidoPago;

    private final EnviarMensagemPagamentoRelatorio enviarMensagemPagamentoRelatorio;

    private final PagamentoRepository pagamentoRepository;

    public void pagar(Pagamento pagamento) throws RealizarPagamentoCartaoException {
        Pagamento pagamentoBanco = this.pagamentoRepository.buscarPorId(pagamento.getId());

        confirmarPagamentoCartao(pagamentoBanco);

        pagamentoBanco.setStatus(PagamentoStatus.PAGO);
        pagamentoBanco.setDataPagamento(LocalDateTime.now());

        log.info("Salvando pagamento");
        pagamentoRepository.salvar(pagamentoBanco);

        log.info("Enviar mensagem para atualizar o pedido");
        enviarMensagemPedidoPago.enviar(pagamentoBanco.getPedido());

        log.info("Enviar mensagem de pagamento realizado para relatorio");
        enviarMensagemPagamentoRelatorio.enviar(pagamentoBanco);
    }

    private void confirmarPagamentoCartao(Pagamento pagamento) {
        log.info("Confirmando pagamento");

        try {
            confirmarPagamentoCartao.confirmar(pagamento.getCarteira(), pagamento.getTotal());
        } catch (Exception e) {
            log.info("Error ao confirmar o pagamento", e);

            String message = "Não foi possível confirmar o pagamento com a operadora do cartao";
            throw new RealizarPagamentoCartaoException(message);
        }
    }
}
