package br.unime.edu.arquitetura.hexagonal.dominio.dtos;

import br.unime.edu.arquitetura.hexagonal.dominio.Categoria;
import br.unime.edu.arquitetura.hexagonal.dominio.ProdutoPreco;

import java.util.List;

public class ProdutoDTO {
    private String sku;
    private String nome;
    private Integer quantidade;
    private Categoria categoria;
    private ProdutoPreco produtoPreco;

    public ProdutoDTO() {
        super();
    }

    public ProdutoDTO(String sku, String nome, Integer quantidade, Categoria categoria, ProdutoPreco produtoPreco) {
        this.sku = sku;
        this.nome = nome;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.produtoPreco = produtoPreco;
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

}
