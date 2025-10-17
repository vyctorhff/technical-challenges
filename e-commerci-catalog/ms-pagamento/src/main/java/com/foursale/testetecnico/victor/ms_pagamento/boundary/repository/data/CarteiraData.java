package com.foursale.testetecnico.victor.ms_pagamento.boundary.repository.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@Table("tb_carteira")
public class CarteiraData {

    @Id
    private UUID id;

    private Integer cv;

    private String numero;

    private LocalDate data;
}
