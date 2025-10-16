package com.foursale.testetecnico.victor.ms_relatorio.core.model;

import jakarta.annotation.security.DenyAll;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pagamento {

    private UUID id;
}
