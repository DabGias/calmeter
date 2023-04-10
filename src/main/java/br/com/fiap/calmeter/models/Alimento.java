package br.com.fiap.calmeter.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tb_alimento")
public class Alimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alimento")
    private Long id;

    @Column(name = "nome_alimento")
    @NotBlank
    private String nome;

    @Column(name = "desc_alimento")
    @NotBlank
    private String descricao;

    @Column(name = "cal_alimento")
    @Min(value = 0, message = "As calorias devem ser positivas")
    @NotNull
    private int calorias;
}
