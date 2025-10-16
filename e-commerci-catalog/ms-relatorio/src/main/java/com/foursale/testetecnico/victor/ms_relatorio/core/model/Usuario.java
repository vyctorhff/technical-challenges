package com.foursale.testetecnico.victor.ms_relatorio.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    private UUID id;

    private String nome;
}
