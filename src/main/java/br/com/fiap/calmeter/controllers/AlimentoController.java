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

import br.com.fiap.calmeter.models.Alimento;
import br.com.fiap.calmeter.repositories.AlimentoRepository;

@RestController
@RequestMapping("calmeter/alimento")
public class AlimentoController {
    Logger log = LoggerFactory.getLogger(AlimentoController.class);
    
    @Autowired
    AlimentoRepository repo;

    @GetMapping
    public List<Alimento> index() {
        return repo.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Alimento> show(@PathVariable Long id) {
        log.info("buscar alimento com id: " + id);

        Optional<Alimento> alimento = repo.findById(id);

        if (alimento.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(alimento.get());
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

        Optional<Alimento> alimento = repo.findById(id);

        if (alimento.isEmpty()) return ResponseEntity.notFound().build();

        BeanUtils.copyProperties(alimentoAtualizado, alimento, "id");

        repo.save(alimento.get());

        return ResponseEntity.ok(alimento.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Alimento> destroy(@PathVariable Long id) {
        log.info("deletar alimento com o id: " + id);

        Optional<Alimento> alimento = repo.findById(id);

        if (alimento.isEmpty()) return ResponseEntity.notFound().build();

        repo.delete(alimento.get());

        return ResponseEntity.noContent().build();
    }
}
