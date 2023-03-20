package br.com.fiap.calmeter.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.calmeter.models.Refeicao;
import br.com.fiap.calmeter.repositories.RefeicaoRepository;

@RestController
@RequestMapping("calmeter/refeicao")
public class RefeicaoController {
    Logger log = LoggerFactory.getLogger(RefeicaoController.class);
    
    @Autowired
    RefeicaoRepository repo;

    @GetMapping
    public List<Refeicao> index() {
        return repo.findAll();
    }

    @PostMapping
    public ResponseEntity<Refeicao> create(@RequestBody Refeicao refeicao) {
        log.info("cadastrar refeição: " + refeicao);

        repo.save(refeicao);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Refeicao> update(@PathVariable Long id, @RequestBody Refeicao refeicaoAtualizada) {
        log.info("atualizar a refeição com id: " + id);

        Optional<Refeicao> refeicao = repo.findById(id);

        if (refeicao.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        BeanUtils.copyProperties(refeicaoAtualizada, refeicao, "id");

        repo.save(refeicao.get());

        return ResponseEntity.ok(refeicao.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Refeicao> destroy(@PathVariable Long id) {
        log.info("deletar refeição com id: " + id);

        Optional<Refeicao> refeicao = repo.findById(id);

        if (refeicao.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        repo.delete(refeicao.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
