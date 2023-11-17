package br.unime.edu.arquitetura.hexagonal.dominio.dtos;

public class VendedorDTO {
    private String sku;
    private String nome;
    private Double preco;
    private Double quantidade;

    public VendedorDTO() {
        super();
    }

    public VendedorDTO(String sku, String nome, Double preco, Double quantidade) {
        this.sku = sku;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
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

}