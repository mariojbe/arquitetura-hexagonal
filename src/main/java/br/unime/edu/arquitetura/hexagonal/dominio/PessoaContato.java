package br.unime.edu.arquitetura.hexagonal.dominio;

import br.unime.edu.arquitetura.hexagonal.dominio.dtos.PessoaContatoDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.ProdutoDTO;

public class PessoaContato {

    private Long id;
    private String telefone;
    private String email;
    private String whatsapp;
    private Vendedor vendedor;

    public PessoaContato() {
    }

    public PessoaContato(Long id, String telefone, String email, String whatsapp, Vendedor vendedor) {
        this.id = id;
        this.telefone = telefone;
        this.email = email;
        this.whatsapp = whatsapp;
        this.vendedor = vendedor;
    }

    public Long getId() {
        return id;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }


    public PessoaContato(PessoaContatoDTO pessoaContatoDTO) {
        this.telefone = pessoaContatoDTO.getTelefone();
        this.email = pessoaContatoDTO.getEmail();
        this.whatsapp = pessoaContatoDTO.getWhatsapp();
        this.vendedor = pessoaContatoDTO.getVendedor();
    }

    /*public void atualizarEstoque(double quantidade) {
        this.quantidade = quantidade;
    }*/

    public PessoaContatoDTO toPessoaContatoDTO() {
        return new PessoaContatoDTO(this.telefone, this.email, this.whatsapp, this.vendedor);
    }

}
