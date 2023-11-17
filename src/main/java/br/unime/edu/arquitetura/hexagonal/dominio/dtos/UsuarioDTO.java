package br.unime.edu.arquitetura.hexagonal.dominio.dtos;

public class UsuarioDTO {
    private String nome;
    private String email;
    private String senha;

    public UsuarioDTO() {
        super();
    }

    public UsuarioDTO(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

}
