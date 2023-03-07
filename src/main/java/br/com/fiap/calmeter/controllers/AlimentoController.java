package br.com.fiap.calmeter.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.calmeter.models.Alimento;

@RestController
public class AlimentoController {
    @GetMapping("/api/alimento")
    public Alimento index() {
        return new Alimento("Arroz e feijão", "Um prato de arroz e feijão bem bom", 1500);
    }
}
