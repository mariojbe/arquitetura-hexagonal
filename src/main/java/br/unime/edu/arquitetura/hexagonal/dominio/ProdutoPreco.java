package br.unime.edu.arquitetura.hexagonal.dominio;

import br.unime.edu.arquitetura.hexagonal.dominio.dtos.ProdutoPrecoDTO;

import java.util.List;

public class ProdutoPreco {

    private Long id;
    private Double preco;

    public List<Produto> produtos;

    public ProdutoPreco() {
    }

    public ProdutoPreco(Long id, Double preco, List<Produto> produtos) {
        this.id = id;
        this.preco = preco;
        this.produtos = produtos;
    }

    public Long getId() {
        return id;
    }

    public Double getPreco() {
        return preco;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public ProdutoPreco(ProdutoPrecoDTO produtoPrecoDTO) {
        this.preco = produtoPrecoDTO.getPreco();
        this.produtos = produtoPrecoDTO.getProdutos();
    }

    /*public void atualizarEstoque(double quantidade) {
        this.quantidade = quantidade;
    }*/

    public ProdutoPrecoDTO toProdutoPrecoDTO() {
        return new ProdutoPrecoDTO(this.preco, this.produtos);
    }

}
