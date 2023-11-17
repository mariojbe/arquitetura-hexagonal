package br.unime.edu.arquitetura.hexagonal.dominio;

import br.unime.edu.arquitetura.hexagonal.dominio.dtos.ProdutoDTO;
import br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.entidades.CategoriaEntity;
import br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.entidades.ProdutoPrecoEntity;

import java.util.List;
import java.util.UUID;

public class Produto {

    private Long id;
    private String sku;
    private String nome;
    private Integer quantidade;
    private Categoria categoria;
    private ProdutoPreco produtoPreco;

    public Produto() {
    }

    public Produto(Long id, String sku, String nome, Integer quantidade, Categoria categoria, ProdutoPreco produtoPreco) {
        this.id = id;
        this.sku = sku;
        this.nome = nome;
        this.categoria = categoria;
        this.produtoPreco = produtoPreco;
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

    public Integer getQuantidade() {
        return quantidade;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public ProdutoPreco getProdutoPreco() {
        return produtoPreco;
    }


    public Produto(ProdutoDTO produtoDTO) {
        this.sku = produtoDTO.getSku();
        this.nome = produtoDTO.getNome();
        this.quantidade = produtoDTO.getQuantidade();
        this.categoria = produtoDTO.getCategoria();
        this.produtoPreco = produtoDTO.getProdutoPreco();
    }

    public void atualizarEstoque(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public ProdutoDTO toProdutoDTO() {
        return new ProdutoDTO(this.sku, this.nome, this.quantidade, this.categoria, this.produtoPreco);
    }
}