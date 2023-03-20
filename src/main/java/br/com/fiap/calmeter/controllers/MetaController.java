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

import br.com.fiap.calmeter.models.Meta;
import br.com.fiap.calmeter.repositories.MetaRepository;

@RestController
@RequestMapping("calmeter/meta")
public class MetaController {
    Logger log = LoggerFactory.getLogger(MetaController.class);
    
    @Autowired
    MetaRepository repo;

    @GetMapping
    public List<Meta> index() {
        return repo.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Meta> show(@PathVariable Long id) {
        log.info("buscar meta com id: " + id);

        Optional<Meta> meta = repo.findById(id);

        if (meta.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(meta.get());
    }

    @PostMapping
    public ResponseEntity<Meta> create(@RequestBody Meta meta) {
        log.info("cadastrar meta: " + meta);

        repo.save(meta);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Meta> update(@PathVariable Long id, @RequestBody Meta metaAtualizada) {
        log.info("atualizar a meta com id: " + id);

        Optional<Meta> meta = repo.findById(id);

        if (meta.isEmpty()) return ResponseEntity.notFound().build();

        BeanUtils.copyProperties(metaAtualizada, meta);

        repo.save(meta.get());

        return ResponseEntity.ok(meta.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Meta> destroy(@PathVariable Long id) {
        log.info("deletar meta com o id: " + id);

        Optional<Meta> meta = repo.findById(id);

        if (meta.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        repo.delete(meta.get());

        return ResponseEntity.noContent().build();
    }
}
