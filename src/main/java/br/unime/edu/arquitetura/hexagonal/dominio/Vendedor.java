package br.unime.edu.arquitetura.hexagonal.dominio;

import br.unime.edu.arquitetura.hexagonal.dominio.dtos.ProdutoDTO;

public class Vendedor extends Usuario {

    private Long id;
    private String sku;
    private String nome;
    private Double preco;
    private Double quantidade;

    public Produto() {
    }

    public Produto(Long id, String sku, String nome, Double preco, Double quantidade) {
        this.id = id;
        this.sku = sku;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public String getSku() {
        return sku;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public Produto(ProdutoDTO produtoDTO) {
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
