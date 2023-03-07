package br.com.fiap.calmeter.controllers;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.calmeter.models.Meta;

@RestController
public class MetaController {
    @GetMapping("/api/meta")
    public Meta index() {
        return new Meta(30000, LocalDate.now(), LocalDate.now());
    }
}
