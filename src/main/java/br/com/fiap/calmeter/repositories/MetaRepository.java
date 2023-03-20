package br.com.fiap.calmeter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.calmeter.models.Meta;

public interface MetaRepository extends JpaRepository<Meta, Long> {
    
}
