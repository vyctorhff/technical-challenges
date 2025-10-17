package com.foursale.testetecnico.victor.ms_pagamento.helpers.model;

import com.foursale.testetecnico.victor.ms_pagamento.core.model.Carteira;

public class CarteiraHelper {
    public static Carteira getBase() {
        Carteira carteira = new Carteira();
        carteira.setCv(2);
        carteira.setNumero("12312");
        return carteira;
    }
}
