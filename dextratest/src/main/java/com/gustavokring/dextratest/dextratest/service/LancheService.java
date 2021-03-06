package com.gustavokring.dextratest.dextratest.service;

import com.gustavokring.dextratest.dextratest.model.Lanche;
import com.gustavokring.dextratest.dextratest.model.enums.Ingrediente;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LancheService {

    private boolean isLightPromo(Lanche lanche) {

        return (lanche.getIngredientes().contains(Ingrediente.ALFACE)
                && !lanche.getIngredientes().contains(Ingrediente.BACON));
    }

    private boolean isMuitaCarnePromo(Lanche lanche) {

        return lanche.getIngredientes().stream()
                .filter(ingrediente -> ingrediente.equals(Ingrediente.HAMBURGUER_CARNE)).count() >= 3;
    }

    private boolean isMuitoQueijoPromo(Lanche lanche) {

        return lanche.getIngredientes().stream()
                .filter(ingrediente -> ingrediente.equals(Ingrediente.QUEIJO)).count() >= 3;
    }

    public double discountLight(Lanche lanche) {

        return isLightPromo(lanche) ? lanche.getValorLanche() * 90/100 : 0;
    }

    public double discountMuitaCarne(Lanche lanche) {

        long numeroDescontado = 0;
        if (isMuitaCarnePromo(lanche)) {

            long numeroCarnes = lanche.getIngredientes().stream()
                    .filter(ingrediente -> ingrediente.equals(Ingrediente.HAMBURGUER_CARNE)).count();

            numeroDescontado = (long) Math.floor(numeroCarnes % 3);
        }

        return lanche.getValorLanche() - numeroDescontado * Ingrediente.HAMBURGUER_CARNE.getValor();

    }

    public double discountMuitoQueijo(Lanche lanche) {

        long numeroDescontado = 0;
        if (isMuitoQueijoPromo(lanche)) {

            long numeroCarnes = lanche.getIngredientes().stream()
                    .filter(ingrediente -> ingrediente.equals(Ingrediente.QUEIJO)).count();

            numeroDescontado = (long) Math.floor(numeroCarnes % 3);
        }

        return lanche.getValorLanche() - numeroDescontado * Ingrediente.QUEIJO.getValor();

    }

    public List<Lanche> getListFromCardapio() {

            return Arrays.asList(
                    Lanche.builder()
                        .nomeLanche("X-Bacon")
                        .ingredientes(
                            Arrays.asList(Ingrediente.BACON,Ingrediente.HAMBURGUER_CARNE,Ingrediente.QUEIJO)
                        ).build(),
                    Lanche.builder()
                        .nomeLanche("X-Burger")
                        .ingredientes(
                            Arrays.asList(Ingrediente.HAMBURGUER_CARNE, Ingrediente.QUEIJO)
                        ).build(),
                    Lanche.builder()
                        .nomeLanche("X-Egg")
                        .ingredientes(
                            Arrays.asList(Ingrediente.OVO, Ingrediente.HAMBURGUER_CARNE, Ingrediente.QUEIJO)
                        ).build(),
                    Lanche.builder()
                        .nomeLanche("X-Egg Bacon")
                        .ingredientes(
                            Arrays.asList(Ingrediente.OVO, Ingrediente.HAMBURGUER_CARNE, Ingrediente.QUEIJO, Ingrediente.BACON)
                        ).build()
                    );

    }


}
