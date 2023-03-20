package br.com.fiap.calmeter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.calmeter.models.Refeicao;

public interface RefeicaoRepository extends JpaRepository<Refeicao, Long> {
    
}
