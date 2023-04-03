package br.com.fiap.calmeter.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.ForeignKey;

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

    @ManyToOne(
        fetch = FetchType.EAGER,
        cascade = CascadeType.REFRESH
    )
    @JoinColumn(
        name = "id_refeicao",
        referencedColumnName = "id_refeicao",
        foreignKey = @ForeignKey(
            name = "fk_tb_refeicao",
            value = ConstraintMode.CONSTRAINT
        )
    )
    @NotNull
    private Refeicao refeicao;
}
