package br.com.fiap.calmeter.models;

import java.time.LocalDate;

public class Meta {
    private Long id;
    private int meta;
    private LocalDate dataInicio;
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
