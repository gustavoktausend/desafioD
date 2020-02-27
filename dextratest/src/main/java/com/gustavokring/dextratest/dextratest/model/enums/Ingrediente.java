package com.gustavokring.dextratest.dextratest.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Ingrediente {

    ALFACE(0.40),
    BACON(2.00),
    HAMBURGUER_CARNE(3.00),
    OVO(0.80),
    QUEIJO(1.50);

    private double valor;

}
