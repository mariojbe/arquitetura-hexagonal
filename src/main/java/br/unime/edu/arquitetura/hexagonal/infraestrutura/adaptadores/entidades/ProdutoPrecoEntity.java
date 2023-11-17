package br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.entidades;

import br.unime.edu.arquitetura.hexagonal.dominio.Categoria;
import br.unime.edu.arquitetura.hexagonal.dominio.ProdutoPreco;

import javax.persistence.*;

@Entity
@Table(name = "produto-preco")
public class ProdutoPrecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double preco;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoEntity produto;

    public ProdutoPrecoEntity() {
    }

    public ProdutoPrecoEntity(ProdutoPreco produtoPreco) {
        this.preco = produtoPreco.getPreco();
    }

    public void atualizar(ProdutoPreco produtoPreco) {
        this.preco = produtoPreco.getPreco();
    }

    public Categoria toCategoria() {
        return new Categoria(this.id, this.nome);
    }

}
