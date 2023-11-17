package br.unime.edu.arquitetura.hexagonal.dominio.dtos;

import br.unime.edu.arquitetura.hexagonal.dominio.Produto;

import java.util.List;

public class ProdutoPrecoDTO {
    private Double preco;
    private List<Produto> produtos;

    public ProdutoPrecoDTO() {
        super();
    }

    public ProdutoPrecoDTO(Double preco, List<Produto> produtos) {
        this.preco = preco;
        this.produtos = produtos;
    }

    public Double getPreco() {
        return preco;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

}
