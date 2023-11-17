package br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.entidades;

import br.unime.edu.arquitetura.hexagonal.dominio.Categoria;
import br.unime.edu.arquitetura.hexagonal.dominio.Produto;
import br.unime.edu.arquitetura.hexagonal.dominio.ProdutoPreco;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "produto-preco")
public class ProdutoPrecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double preco;

    @OneToMany(mappedBy = "produto")
    private List<Produto> produtos;

    public ProdutoPrecoEntity() {
    }

    public ProdutoPrecoEntity(ProdutoPreco produtoPreco) {
        this.preco = produtoPreco.getPreco();
        this.produtos = produtoPreco.getProdutos();
    }

    public void atualizar(ProdutoPreco produtoPreco) {
        this.preco = produtoPreco.getPreco();
        this.produtos = produtoPreco.getProdutos();
    }

    public ProdutoPreco toProdutoPreco() {
        return new ProdutoPreco(this.id, this.preco, this.produtos);
    }

}
