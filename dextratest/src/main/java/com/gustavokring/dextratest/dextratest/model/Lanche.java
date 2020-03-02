package com.gustavokring.dextratest.dextratest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.gustavokring.dextratest.dextratest.model.enums.Ingrediente;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonDeserialize(builder = Lanche.LancheBuilder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@With
public class Lanche {

    private List<Ingrediente> ingredientes;

    private String nomeLanche;

    private double valorLanche;

    public double getValorLanche() {
        valorLanche = ingredientes.stream().mapToDouble(Ingrediente::getValor).sum();
        return valorLanche;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class LancheBuilder {}

}
