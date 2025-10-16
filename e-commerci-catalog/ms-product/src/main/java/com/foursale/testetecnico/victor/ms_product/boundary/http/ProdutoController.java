package com.foursale.testetecnico.victor.ms_product.boundary.http;

import com.foursale.testetecnico.victor.ms_product.boundary.http.dto.AlterarProdutoRequestDTO;
import com.foursale.testetecnico.victor.ms_product.boundary.http.dto.CriarProdutoRequestDTO;
import com.foursale.testetecnico.victor.ms_product.boundary.service.AlterarProdutoService;
import com.foursale.testetecnico.victor.ms_product.boundary.service.CriarProdutoService;
import com.foursale.testetecnico.victor.ms_product.boundary.service.RemoverProdutoService;
import com.foursale.testetecnico.victor.ms_product.core.model.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final CriarProdutoService criarProdutoService;

    private final AlterarProdutoService alterarProdutoService;

    private final RemoverProdutoService removerProdutoService;

    @PostMapping
    public ResponseEntity<Void> criar(CriarProdutoRequestDTO produtoRequestDTO) {
        Produto produto = produtoRequestDTO.toModel();
        criarProdutoService.criar(produto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> alterar(AlterarProdutoRequestDTO produtoRequestDTO) {
        Produto produto = produtoRequestDTO.toModel();
        criarProdutoService.criar(produto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{ìd}")
    public ResponseEntity<Void> remover(@PathVariable("id") String id) {
        removerProdutoService.remover(UUID.fromString(id));
        return ResponseEntity.ok().build();
    }
}
