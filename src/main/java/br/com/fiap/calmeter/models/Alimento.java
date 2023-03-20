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
import jakarta.persistence.ForeignKey;

@Entity
@Table(name = "tb_alimento")
public class Alimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alimento")
    private Long id;

    @Column(name = "nome_alimento")
    private String nome;

    @Column(name = "desc_alimento")
    private String descricao;

    @Column(name = "cal_alimento")
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
    private Refeicao refeicao;
    
    public Alimento() {}

    public Alimento(Long id, String nome, String descricao, int calorias, Refeicao refeicao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.calorias = calorias;
        this.refeicao = refeicao;
    }

    public Alimento(String nome, String descricao, int calorias, Refeicao refeicao) {
        this.nome = nome;
        this.descricao = descricao;
        this.calorias = calorias;
        this.refeicao = refeicao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public Refeicao getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(Refeicao refeicao) {
        this.refeicao = refeicao;
    }

    @Override
    public String toString() {
        return "Alimento [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", calorias=" + calorias
                + ", idRefeicao=" + refeicao + "]";
    }
}
