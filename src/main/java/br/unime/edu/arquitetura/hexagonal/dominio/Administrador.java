package br.unime.edu.arquitetura.hexagonal.dominio;

import br.unime.edu.arquitetura.hexagonal.dominio.dtos.AdministradorDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.ProdutoDTO;

public class Administrador extends Usuario {

    private Long id;
    private String pin;

    private Administrador() {
    }

    public Administrador(Long id, String pin) {
        this.id = id;
        this.pin = pin;
    }

    public Long getId() {
        return id;
    }

    public Long getPin() {
        return pin;
    }

    public Administrador(AdministradorDTO AdministradorDTO) {
        this.sku = produtoDTO.getSku();
        this.nome = produtoDTO.getNome();
        this.preco = produtoDTO.getPreco();
        this.quantidade = produtoDTO.getQuantidade();
    }

    public void atualizarEstoque(double quantidade) {
        this.quantidade = quantidade;
    }

    public ProdutoDTO toProdutoDTO() {
        return new ProdutoDTO(this.sku, this.nome, this.preco, this.quantidade);
    }

}
