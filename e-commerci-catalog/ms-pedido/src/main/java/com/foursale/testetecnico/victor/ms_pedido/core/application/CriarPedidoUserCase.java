package com.foursale.testetecnico.victor.ms_pedido.core.application;

import com.foursale.testetecnico.victor.ms_pedido.core.application.port.EnviarMensagemPagamento;
import com.foursale.testetecnico.victor.ms_pedido.core.application.port.PedidoRepository;
import com.foursale.testetecnico.victor.ms_pedido.core.application.port.ReservarEstoque;
import com.foursale.testetecnico.victor.ms_pedido.core.application.port.ReservarProduto;
import com.foursale.testetecnico.victor.ms_pedido.core.application.validator.CriarPedidoValidador;
import com.foursale.testetecnico.victor.ms_pedido.core.exception.CriarPedidoException;
import com.foursale.testetecnico.victor.ms_pedido.core.model.OperacaoPagamento;
import com.foursale.testetecnico.victor.ms_pedido.core.model.Pedido;
import com.foursale.testetecnico.victor.ms_pedido.core.model.PedidoStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
public class CriarPedidoUserCase {

    private final PedidoRepository pedidoRepository;

    private final ReservarProduto reservarProduto;

    private final ReservarEstoque reservarEstoque;

    private final EnviarMensagemPagamento enviarMensagemPagamento;

    private final CriarPedidoValidador validador;

    public void criar(Pedido pedido) throws CriarPedidoException {
        validador.validar(pedido);

        pedido.setPedidoStatus(PedidoStatus.PENDENTE);
        pedido.setDataCriacao(LocalDateTime.now());

        log.info("Reservando produto");
        reservarProduto.reservar(pedido);

        log.info("Reservando estoque");
        reservarEstoque(pedido);

        log.info("Criando pedido");
        pedidoRepository.salvar(pedido);

        log.info("Enviando mensagem pagamento");
        enviarMensagemPagamento.enviar(pedido, OperacaoPagamento.CRIACAO);
    }

    private void reservarEstoque(Pedido pedido) {
        boolean isReservado = reservarEstoque.reservar(pedido);
        if (!isReservado) {
            pedido.setPedidoStatus(PedidoStatus.CANCELADO);
        }
    }
}

