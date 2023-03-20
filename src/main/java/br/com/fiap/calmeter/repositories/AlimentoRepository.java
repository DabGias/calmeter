package br.com.fiap.calmeter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.calmeter.models.Alimento;

public interface AlimentoRepository extends JpaRepository<Alimento, Long> {
    
}
