package br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.entidades;

import br.unime.edu.arquitetura.hexagonal.dominio.Produto;

import javax.persistence.*;

@Entity
@Table(name = "produtos")
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sku;
    private String nome;
    private Double preco;
    private Double quantidade;

    // Relacionamento um-para-um com Categoria
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    private CategoriaEntity categoria;

    public ProdutoEntity() {
    }

    public ProdutoEntity(Produto produto) {
        this.sku = produto.getSku();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.quantidade = produto.getQuantidade();
    }

    public void atualizar(Produto produto) {
        this.sku = produto.getSku();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.quantidade = produto.getQuantidade();
    }

    public Produto toProduto() {
        return new Produto(this.id, this.sku, this.nome, this.quantidade, this.preco);
    }
}
