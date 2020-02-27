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
@JsonDeserialize(builder = Lanche.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@With
public class Lanche {


    private List<Ingrediente> ingredientes;


    public double getValorLanche() { return ingredientes.stream().mapToDouble(Ingrediente::getValor).sum(); }

    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder {}

}
