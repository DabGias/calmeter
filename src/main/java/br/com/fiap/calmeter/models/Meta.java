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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

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

    public Meta() {}

    public Meta(Long id, int meta, LocalDate dataInicio, LocalDate dataFim) {
        this.id = id;
        this.meta = meta;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Meta(int meta, LocalDate dataInicio, LocalDate dataFim) {
        this.meta = meta;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMeta() {
        return meta;
    }

    public void setMeta(int meta) {
        this.meta = meta;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    @Override
    public String toString() {
        return "Meta [meta=" + meta + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + "]";
    }
}
