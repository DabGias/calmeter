package br.com.fiap.calmeter.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.calmeter.global.Finder;
import br.com.fiap.calmeter.models.Alimento;

@RestController
public class AlimentoController {
    Logger log = LoggerFactory.getLogger(AlimentoController.class);
    List<Alimento> alimentos = new ArrayList<>();

    @GetMapping("calmeter/api/alimento")
    public List<Alimento> index() {
        return alimentos;
    }

    @GetMapping("calmeter/api/alimento/{id}")
    public ResponseEntity<Alimento> show(@PathVariable Long id) {
        log.info("buscar alimento com id: " + id);

        Optional<Alimento> alimento = Finder.finderAlimento(id, alimentos);

        if (alimento.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(alimento.get());
    }

    @PostMapping("calmeter/api/alimento")
    public ResponseEntity<Alimento> create(@RequestBody Alimento alimento) {
        log.info("cadastrar alimento: " + alimento);

        alimento.setId(alimentos.size() + 1l);
        alimentos.add(alimento);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("calmeter/api/alimento/{id}")
    public ResponseEntity<Alimento> update(@PathVariable Long id, @RequestBody Alimento alimentoAtualizado) {
        log.info("atualizar o alimento com id: " + id);

        Optional<Alimento> alimento = Finder.finderAlimento(id, alimentos);

        if (alimento.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        alimentos.remove(alimento.get());
        alimentoAtualizado.setId(id);
        alimentos.add(alimentoAtualizado);

        return ResponseEntity.ok(alimento.get());
    }

    @DeleteMapping("calmeter/api/alimento/{id}")
    public ResponseEntity<Alimento> destroy(@PathVariable Long id) {
        log.info("deletar alimento com o id: " + id);

        Optional<Alimento> alimento = Finder.finderAlimento(id, alimentos);

        if (alimento.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        alimentos.remove(alimento.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
