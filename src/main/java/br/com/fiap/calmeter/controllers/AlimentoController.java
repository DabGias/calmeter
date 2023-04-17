package br.com.fiap.calmeter.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

import br.com.fiap.calmeter.models.Alimento;
import br.com.fiap.calmeter.repositories.AlimentoRepository;

@RestController
@RequestMapping("calmeter/alimento")
public class AlimentoController {
    Logger log = LoggerFactory.getLogger(AlimentoController.class);
    
    @Autowired
    AlimentoRepository repo;

    @Autowired
    PagedResourcesAssembler<Alimento> assembler;

    @GetMapping
    public PagedModel<EntityModel<Alimento>> index(@PageableDefault(size = 5) Pageable pageable) {
        return assembler.toModel(repo.findAll(pageable));
    }

    @GetMapping("{id}")
    public EntityModel<Alimento> show(@PathVariable Long id) {
        log.info("buscar alimento com id: " + id);

        Alimento alimento = repo.findById(id).orElseThrow(() -> 
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Alimento não encontrado")
        );

        return alimento.toModel();
    }

    @PostMapping
    public ResponseEntity<Alimento> create(@RequestBody Alimento alimento) {
        log.info("cadastrar alimento: " + alimento);

        repo.save(alimento);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Alimento> update(@PathVariable Long id, @RequestBody Alimento alimentoAtualizado) {
        log.info("atualizar o alimento com id: " + id);

        Alimento alimento = repo.findById(id).orElseThrow(() -> 
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Alimento não encontrado")
        );

        BeanUtils.copyProperties(alimentoAtualizado, alimento, "id");

        repo.save(alimento);

        return ResponseEntity.ok(alimento);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Alimento> destroy(@PathVariable Long id) {
        log.info("deletar alimento com o id: " + id);

        Alimento alimento = repo.findById(id).orElseThrow(() -> 
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Alimento não encontrado")
        );

        repo.delete(alimento);

        return ResponseEntity.noContent().build();
    }
}
