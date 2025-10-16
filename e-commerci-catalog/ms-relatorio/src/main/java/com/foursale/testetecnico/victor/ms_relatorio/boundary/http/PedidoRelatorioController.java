package com.foursale.testetecnico.victor.ms_relatorio.boundary.http;

import com.foursale.testetecnico.victor.ms_relatorio.boundary.http.dtos.FaturamentoUltimoMesResponseDTO;
import com.foursale.testetecnico.victor.ms_relatorio.boundary.http.dtos.UsuarioMaisCompraramResponseDTO;
import com.foursale.testetecnico.victor.ms_relatorio.boundary.service.PedidoRelatorioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/relatorio/pedidos")
@RequiredArgsConstructor
public class PedidoRelatorioController {

    private final PedidoRelatorioService pedidoRelatorioService;

    @GetMapping("/maiores-compradores")
    public ResponseEntity<List<UsuarioMaisCompraramResponseDTO>> maioresCompradores() {
        int numeroPrimeirosUsuario = 5;
        List<UsuarioMaisCompraramResponseDTO> result = pedidoRelatorioService.findUsuariosQueMaisCompraram(numeroPrimeirosUsuario)
                .stream()
                .map(UsuarioMaisCompraramResponseDTO::fromPedidoData)
                .toList();

        return ResponseEntity.ok(result);
    }

    @GetMapping("/medio")
    public ResponseEntity<List<UsuarioMaisCompraramResponseDTO>> pedidoMedio() {
        List<UsuarioMaisCompraramResponseDTO> result = pedidoRelatorioService.findPedidoMedioPorUsuario()
                .stream()
                .map(UsuarioMaisCompraramResponseDTO::fromPedidoData)
                .toList();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/faturamento-atual")
    public ResponseEntity<FaturamentoUltimoMesResponseDTO> faturamentoAtual() {
        pedidoRelatorioService.countTotalFaturamentoPorMes();
        return ResponseEntity.ok().build();
    }
}
