package com.foursale.testetecnico.victor.ms_pagamento.boundary.http;

import com.foursale.testetecnico.victor.ms_pagamento.boundary.http.dto.PagamentoRequestDTO;
import com.foursale.testetecnico.victor.ms_pagamento.boundary.service.RealizarPagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/pagamento")
@RequiredArgsConstructor
public class RealizarPagamentoController {

    private final RealizarPagamentoService realizarPagamentoService;

    @PostMapping
    public ResponseEntity<Void> pagar(@RequestBody PagamentoRequestDTO dto) {
        realizarPagamentoService.pagar(dto.toModel());
        return ResponseEntity.ok().build();
    }
}
