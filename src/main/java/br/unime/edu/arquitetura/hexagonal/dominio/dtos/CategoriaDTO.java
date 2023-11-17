package br.unime.edu.arquitetura.hexagonal.dominio.dtos;

public class CategoriaDTO {
    private String nome;

    //default constructor
    public CategoriaDTO() {
        super();
    }

    public CategoriaDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}
