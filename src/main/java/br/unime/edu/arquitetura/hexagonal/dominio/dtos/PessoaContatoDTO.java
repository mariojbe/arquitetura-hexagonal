package br.unime.edu.arquitetura.hexagonal.dominio.dtos;

import br.unime.edu.arquitetura.hexagonal.dominio.Vendedor;

public class PessoaContatoDTO {
    private String telefone;
    private String email;
    private String whatsapp;
    private Vendedor vendedor;

    public PessoaContatoDTO() {
        super();
    }

    public PessoaContatoDTO(String telefone, String email, String whatsapp, Vendedor vendedor) {
        this.telefone = telefone;
        this.email = email;
        this.whatsapp = whatsapp;
        this.vendedor = vendedor;
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

}
