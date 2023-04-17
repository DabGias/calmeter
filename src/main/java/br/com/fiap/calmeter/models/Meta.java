package br.com.fiap.calmeter.models;

import java.time.LocalDate;

import org.springframework.data.domain.Pageable;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;

import br.com.fiap.calmeter.controllers.MetaController;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tb_meta")
public class Meta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_meta")
    private Long id;

    @Column(name = "cal_meta")
    @Min(value = 0, message = "A meta de calorias deve ser positiva")
    @NotNull
    private int meta;

    @Column(name = "dt_inicio_meta")
    @Temporal(TemporalType.DATE)
    @NotNull
    private LocalDate dataInicio;

    @Column(name = "dt_fim_meta")
    @Temporal(TemporalType.DATE)
    @NotNull
    private LocalDate dataFim;

    public EntityModel<Meta> toModel() {
        return EntityModel.of(
            this,
            linkTo(methodOn(MetaController.class).show(id)).withSelfRel(),
            linkTo(methodOn(MetaController.class).destroy(id)).withRel("delete"),
            linkTo(methodOn(MetaController.class).index(Pageable.unpaged())).withRel("all")
        );
    }
}
