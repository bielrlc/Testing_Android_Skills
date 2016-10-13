package br.com.pinhas.cadastroalunos.modelo;

/**
 * Created by Pinhas on 30/09/2016.
 */

public class Aluno {
    private Long id;
    private String nome;
    private String telefone;
    private String endereco;
    private String site;
    private Double nota;

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    //configurando a saída de dados da Lista de Alunos
    @Override
    public String toString() {
        return getId() + " - " + getNome();
    }
}
