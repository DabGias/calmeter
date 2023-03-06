package br.com.fiap.calmeter.models;

public class Alimento {
    private String nome;
    private String descricao;
    private int calorias;
    
    public Alimento() {}

    public Alimento(String nome, String descricao, int calorias) {
        this.nome = nome;
        this.descricao = descricao;
        this.calorias = calorias;
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

    @Override
    public String toString() {
        return "Alimento [nome=" + nome + ", descricao=" + descricao + ", calorias=" + calorias + "]";
    }
}
