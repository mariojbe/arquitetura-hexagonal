package br.unime.edu.arquitetura.hexagonal.dominio;

import br.unime.edu.arquitetura.hexagonal.dominio.dtos.CategoriaDTO;

import java.util.UUID;

public class Categoria {

    private Long id;
    private String nome;

    public Categoria() {
    }

    public Categoria(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }


    public Categoria(CategoriaDTO categoriaDTO) {
        this.nome = categoriaDTO.getNome();
    }

    public void modificarCategoria(String nome) {
        this.nome = nome;
    }

    public CategoriaDTO toCategoriaDTO() {
        return new CategoriaDTO(this.nome);
    }

}
