package com.foursale.testetecnico.victor.ms_produto_busca.boundary.http;

import com.foursale.testetecnico.victor.ms_produto_busca.boundary.http.dtos.ProdutoRequestDTO;
import com.foursale.testetecnico.victor.ms_produto_busca.boundary.http.dtos.ProdutoResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/produto-busca")
public class ProdutoBuscaController {

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> busca(@RequestBody ProdutoRequestDTO requestDTO) {
        return ResponseEntity.ok().build();
    }
}
