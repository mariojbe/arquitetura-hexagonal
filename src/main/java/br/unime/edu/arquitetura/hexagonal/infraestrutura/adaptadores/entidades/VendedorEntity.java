package br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.entidades;

import br.unime.edu.arquitetura.hexagonal.dominio.Categoria;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class VendedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    public VendedorEntity() {
    }

    public VendedorEntity(Categoria categoria) {
        this.nome = categoria.getNome();
    }

    public void atualizar(Categoria categoria) {
        this.nome = categoria.getNome();
    }

    public Categoria toCategoria() {
        return new Categoria(this.id, this.nome);
    }

}
