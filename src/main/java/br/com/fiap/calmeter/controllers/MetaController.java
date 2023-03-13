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
import br.com.fiap.calmeter.models.Meta;

@RestController
public class MetaController {
    Logger log = LoggerFactory.getLogger(MetaController.class);
    List<Meta> metas = new ArrayList<>();

    @GetMapping("calmeter/api/meta")
    public List<Meta> index() {
        return metas;
    }

    @GetMapping("calmeter/api/meta/{id}")
    public ResponseEntity<Meta> show(@PathVariable Long id) {
        log.info("buscar meta com id: " + id);

        Optional<Meta> meta = Finder.finderMeta(id, metas);

        if (meta.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(meta.get());
    }

    @PostMapping("calmeter/api/meta")
    public ResponseEntity<Meta> create(@RequestBody Meta meta) {
        log.info("cadastrar meta: " + meta);

        meta.setId(metas.size() + 1l);
        metas.add(meta);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("calmeter/api/meta/{id}")
    public ResponseEntity<Meta> update(@PathVariable Long id, @RequestBody Meta metaAtualizada) {
        log.info("atualizar a meta com id: " + id);

        Optional<Meta> meta = Finder.finderMeta(id, metas);

        if (meta.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        metas.remove(meta.get());
        metaAtualizada.setId(id);
        metas.add(metaAtualizada);

        return ResponseEntity.ok(meta.get());
    }

    @DeleteMapping("calmeter/api/meta/{id}")
    public ResponseEntity<Meta> destroy(@PathVariable Long id) {
        log.info("deletar meta com o id: " + id);

        Optional<Meta> meta = Finder.finderMeta(id, metas);

        if (meta.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        metas.remove(meta.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
