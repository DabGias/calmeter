package br.com.fiap.calmeter.models;

import java.util.List;

public class Refeicao {
    private Long id;
    private String nome;
    private List<String> alimentos;

    public Refeicao() {}

    public Refeicao(Long id, String nome, List<String> alimentos) {
        this.id = id;
        this.nome = nome;
        this.alimentos = alimentos;
    }

    public Refeicao(String nome, List<String> alimentos) {
        this.nome = nome;
        this.alimentos = alimentos;
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

    public List<String> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(List<String> alimentos) {
        this.alimentos = alimentos;
    }

    @Override
    public String toString() {
        return "Refeicao [id=" + id + ", nome=" + nome + ", alimentos=" + alimentos + "]";
    }
}
