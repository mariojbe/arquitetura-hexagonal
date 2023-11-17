package br.unime.edu.arquitetura.hexagonal.dominio.dtos;

public class UsuarioDTO {
    private String nome;

    public UsuarioDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}
