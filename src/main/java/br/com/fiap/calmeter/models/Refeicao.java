package br.com.fiap.calmeter.models;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;

import br.com.fiap.calmeter.controllers.RefeicaoController;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(
    name = "tb_refeicao",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_nome_refeicao",
            columnNames = "nome_refeicao"
        )
    }
)
public class Refeicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_refeicao")
    private Long id;

    @Column(name = "nome_refeicao")
    @Size(min = 4, max = 100)
    @NotBlank
    private String nome;

    @Column(name = "dt_refeicao")
    @Temporal(TemporalType.DATE)
    @NotNull
    private LocalDate data;

    @OneToMany
    private List<Alimento> alimentos;

    public EntityModel<Refeicao> toModel() {
        return EntityModel.of(
            this,
            linkTo(methodOn(RefeicaoController.class).destroy(id)).withRel("delete"),
            linkTo(methodOn(RefeicaoController.class).index(Pageable.unpaged())).withRel("all")
        );
    }
}
