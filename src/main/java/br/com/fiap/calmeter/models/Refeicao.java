package br.com.fiap.calmeter.models;

public class Refeicao {
    private String nome;

    public Refeicao() {}

    public Refeicao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Refeicao [nome=" + nome + "]";
    }
}
