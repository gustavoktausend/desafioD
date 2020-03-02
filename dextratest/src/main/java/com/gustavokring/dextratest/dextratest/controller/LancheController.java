package com.gustavokring.dextratest.dextratest.controller;

import com.gustavokring.dextratest.dextratest.model.Lanche;
import com.gustavokring.dextratest.dextratest.model.enums.Ingrediente;
import com.gustavokring.dextratest.dextratest.service.LancheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Validated
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/api/lanche")
public class LancheController {

    @Autowired
    private LancheService lancheService;


    @GetMapping
    public List<Lanche> getCardapio() {

        return lancheService.getListFromCardapio();

    }

    @GetMapping("/ingredientes")
    public List<Ingrediente> getAllIngredientes() {
        return Arrays.asList(Ingrediente.values());
    }

    @PostMapping
    public Lanche montarLanche(@RequestBody List<Ingrediente> ingredientes) {
        return Lanche.builder().ingredientes(ingredientes).build();
    }
}
