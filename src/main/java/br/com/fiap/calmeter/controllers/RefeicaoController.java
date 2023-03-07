package br.com.fiap.calmeter.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.calmeter.models.Refeicao;

@RestController
public class RefeicaoController {
    @GetMapping("/api/refeicao")
    public Refeicao index() {
        return new Refeicao("Café da madrugada");
    }
}
