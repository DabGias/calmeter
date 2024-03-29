package br.com.fiap.calmeter.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
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
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.calmeter.models.Meta;
import br.com.fiap.calmeter.repositories.MetaRepository;

@RestController
@RequestMapping("calmeter/meta")
public class MetaController {
    Logger log = LoggerFactory.getLogger(MetaController.class);
    
    @Autowired
    MetaRepository repo;

    @Autowired
    PagedResourcesAssembler<Meta> assembler;

    @GetMapping
    public PagedModel<EntityModel<Meta>> index(Pageable pageable) {
        return assembler.toModel(repo.findAll(pageable));
    }

    @GetMapping("{id}")
    public EntityModel<Meta> show(@PathVariable Long id) {
        log.info("buscar meta com id: " + id);

        Meta meta = repo.findById(id).orElseThrow(() -> 
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Meta não encontrada")
        );

        return meta.toModel();
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

        Meta meta = repo.findById(id).orElseThrow(() -> 
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Meta não encontrada")
        );

        BeanUtils.copyProperties(metaAtualizada, meta, "id");

        repo.save(meta);

        return ResponseEntity.ok(meta);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Meta> destroy(@PathVariable Long id) {
        log.info("deletar meta com o id: " + id);

        Meta meta = repo.findById(id).orElseThrow(() -> 
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Meta não encontrada")
        );

        repo.delete(meta);

        return ResponseEntity.noContent().build();
    }
}
