package br.unime.edu.arquitetura.hexagonal.dominio;

import br.unime.edu.arquitetura.hexagonal.dominio.dtos.UsuarioDTO;

import java.util.UUID;

public class Usuario {

    private Long id;
    private String nome;
    private String email;
    private String senha;

    public Usuario() {
    }

    public Usuario(Long id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Long getId() {
        return id;
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

    public Usuario(UsuarioDTO usuarioDTO) {
        this.nome = usuarioDTO.getNome();
    }

    public void modificarUsuario(Long id) {
        this.id = id;
    }

    public UsuarioDTO toUsuarioDTO() {
        return new UsuarioDTO(this.nome, this.email, this.senha);
    }

}
