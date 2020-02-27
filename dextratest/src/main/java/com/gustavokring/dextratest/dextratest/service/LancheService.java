package com.gustavokring.dextratest.dextratest.service;

import com.gustavokring.dextratest.dextratest.model.Lanche;
import com.gustavokring.dextratest.dextratest.model.enums.Ingrediente;
import org.springframework.stereotype.Service;

@Service
public class LancheService {

    public boolean isLightPromo(Lanche lanche) {

        return (lanche.getIngredientes().contains(Ingrediente.ALFACE)
                && !lanche.getIngredientes().contains(Ingrediente.BACON));
    }

    public boolean isMuitaCarne(Lanche lanche) {

        return lanche.getIngredientes().stream()
                .filter(ingrediente -> ingrediente.equals(Ingrediente.HAMBURGUER_CARNE)).count() % 3 == 0;
    }

    public boolean isMuitoQueijo(Lanche lanche) {

        return lanche.getIngredientes().stream()
                .filter(ingrediente -> ingrediente.equals(Ingrediente.QUEIJO)).count() % 3 == 0;
    }




}
