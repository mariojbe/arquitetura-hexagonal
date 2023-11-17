package br.unime.edu.arquitetura.hexagonal.dominio.dtos;

import br.unime.edu.arquitetura.hexagonal.dominio.PessoaContato;

import java.util.ArrayList;
import java.util.List;

public class VendedorDTO {
    private String matricula;
    private List<PessoaContato> contatos = new ArrayList<>();

    public VendedorDTO() {
        super();
    }

    public VendedorDTO(String matricula, List<PessoaContato> contatos) {
        this.matricula = matricula;
        this.contatos = contatos;
    }

    public String getMatricula() {
        return matricula;
    }

    public List<PessoaContato> getContatos() {
        return contatos;
    }

}
