package br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.entidades;

import br.unime.edu.arquitetura.hexagonal.dominio.Categoria;
import br.unime.edu.arquitetura.hexagonal.dominio.Produto;
import br.unime.edu.arquitetura.hexagonal.dominio.ProdutoPreco;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "produto")
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sku;
    private String nome;
    private Double preco;
    private Integer quantidade;

    // Relacionamento um-para-um com Categoria
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    private Categoria categoria;

    @ManyToOne //
    @JoinColumn(name = "produto_preco_id")
    private ProdutoPreco produtoPreco;

    public ProdutoEntity() {
    }

    public ProdutoEntity(Produto produto) {
        this.sku = produto.getSku();
        this.nome = produto.getNome();
        this.quantidade = produto.getQuantidade();
        this.categoria = produto.getCategoria();
        this.produtoPreco = produto.getProdutoPreco();
    }

    public void atualizar(Produto produto) {
        this.sku = produto.getSku();
        this.nome = produto.getNome();
        this.quantidade = produto.getQuantidade();
        this.categoria = produto.getCategoria();
        this.produtoPreco = produto.getProdutoPreco();
    }

    public Produto toProduto() {
        return new Produto(this.id, this.sku, this.nome, this.quantidade, this.categoria, this.produtoPreco);
    }
}
