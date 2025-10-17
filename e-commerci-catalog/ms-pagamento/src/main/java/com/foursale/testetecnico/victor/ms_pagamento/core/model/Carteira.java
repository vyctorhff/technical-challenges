package com.foursale.testetecnico.victor.ms_pagamento.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Carteira {

    private UUID id;

    private String numero;

    private Integer cv;

    private LocalDate data;
}
