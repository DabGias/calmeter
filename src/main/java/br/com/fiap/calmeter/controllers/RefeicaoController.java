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
import br.com.fiap.calmeter.models.Refeicao;

@RestController
public class RefeicaoController {
    Logger log = LoggerFactory.getLogger(RefeicaoController.class);
    List<Refeicao> refeicoes = new ArrayList<>();

    @GetMapping("calmeter/api/refeicao")
    public List<Refeicao> index() {
        return refeicoes;
    }

    @PostMapping("calmeter/api/refeicao")
    public ResponseEntity<Refeicao> create(@RequestBody Refeicao refeicao) {
        log.info("cadastrar refeição: " + refeicao);

        refeicao.setId(refeicoes.size() + 1l);
        refeicoes.add(refeicao);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("calmeter/api/refeicao/{id}")
    public ResponseEntity<Refeicao> update(@PathVariable Long id, @RequestBody Refeicao refeicaoAtualizada) {
        log.info("atualizar a refeição com id: " + id);

        Optional<Refeicao> refeicao = Finder.finderRefeicao(id, refeicoes);

        if (refeicao.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        refeicoes.remove(refeicao.get());
        refeicaoAtualizada.setId(id);
        refeicoes.add(refeicaoAtualizada);

        return ResponseEntity.ok(refeicao.get());
    }

    @DeleteMapping("calmeter/api/refeicao/{id}")
    public ResponseEntity<Refeicao> destroy(@PathVariable Long id) {
        log.info("deletar refeição com id: " + id);

        Optional<Refeicao> refeicao = Finder.finderRefeicao(id, refeicoes);

        if (refeicao.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        refeicoes.remove(refeicao.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
