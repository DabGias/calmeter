package br.com.fiap.calmeter.models;

public class Alimento {
    private Long id;
    private String nome;
    private String descricao;
    private int calorias;
    private Long idRefeicao;
    
    public Alimento() {}

    public Alimento(Long id, String nome, String descricao, int calorias, Long idRefeicao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.calorias = calorias;
        this.idRefeicao = idRefeicao;
    }

    public Alimento(String nome, String descricao, int calorias, Long idRefeicao) {
        this.nome = nome;
        this.descricao = descricao;
        this.calorias = calorias;
        this.idRefeicao = idRefeicao;
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

    public Long getIdRefeicao() {
        return idRefeicao;
    }

    public void setIdRefeicao(Long idRefeicao) {
        this.idRefeicao = idRefeicao;
    }

    @Override
    public String toString() {
        return "Alimento [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", calorias=" + calorias
                + ", idRefeicao=" + idRefeicao + "]";
    }
}
