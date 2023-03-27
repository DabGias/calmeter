package br.com.fiap.calmeter.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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

    public Refeicao() {}

    public Refeicao(Long id, String nome, LocalDate data) {
        this.id = id;
        this.nome = nome;
        this.data = data;
    }

    public Refeicao(String nome, LocalDate data) {
        this.nome = nome;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Refeicao [id=" + id + ", nome=" + nome + ", data=" + data + "]";
    }
}
