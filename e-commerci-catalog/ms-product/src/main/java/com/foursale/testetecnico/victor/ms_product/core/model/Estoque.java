package com.foursale.testetecnico.victor.ms_product.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Estoque {
    private UUID id;

    private Long quantidade;

    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
}
