package br.unime.edu.arquitetura.hexagonal.dominio;

import br.unime.edu.arquitetura.hexagonal.dominio.dtos.UsuarioDTO;

import java.util.UUID;

public class Usuario {

    private UUID codigo;
    private String nome;

    public Usuario() {
    }

    public Usuario(UUID codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public UUID getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Usuario(UsuarioDTO usuarioDTO) {
        this.nome = usuarioDTO.getNome();
    }

    public void modificarUsuario(UUID codigo) {
        this.codigo = codigo;
    }

    public UsuarioDTO toUsuarioDTO() {
        return new UsuarioDTO(this.nome);
    }

}
