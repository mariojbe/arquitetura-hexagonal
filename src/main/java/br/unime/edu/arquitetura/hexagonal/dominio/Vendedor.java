package br.unime.edu.arquitetura.hexagonal.dominio;

import br.unime.edu.arquitetura.hexagonal.dominio.dtos.ProdutoDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.VendedorDTO;
import br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.entidades.PessoaContatoEntity;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Usuario {

    private Long id;
    private String matricula;

    private List<PessoaContato> contatos = new ArrayList<>();

    public Vendedor() {
    }

    public Vendedor(Long id, String matricula, List<PessoaContato> contatos) {
        this.id = id;
        this.matricula = matricula;
        this.contatos = contatos;
    }

    public Long getId() {
        return id;
    }

    public String getMatricula() {
        return matricula;
    }

    public List<PessoaContato> getContatos() {
        return contatos;
    }

    public Vendedor(VendedorDTO vendedorDTO) {
        this.matricula = vendedorDTO.getMatricula();
        this.contatos = vendedorDTO.getContatos();
    }

    public VendedorDTO toVendedorDTO() {
        return new VendedorDTO(this.matricula, this.contatos);
    }

}
