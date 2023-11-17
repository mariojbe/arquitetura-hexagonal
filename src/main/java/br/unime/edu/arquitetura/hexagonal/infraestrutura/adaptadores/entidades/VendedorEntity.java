package br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.entidades;

import br.unime.edu.arquitetura.hexagonal.dominio.Categoria;
import br.unime.edu.arquitetura.hexagonal.dominio.PessoaContato;
import br.unime.edu.arquitetura.hexagonal.dominio.Vendedor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("vendedor")// é usado para definir o valor discriminador para cada subclasse.
@Table(name = "vendedor")
public class VendedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL) // @OneToMany Um Vendedor vários contatos
    private List<PessoaContato> contatos = new ArrayList<>();

    public VendedorEntity() {
    }

    public VendedorEntity(Vendedor vendedor) {
        this.nome = vendedor.getNome();
        this.contatos = vendedor.getContatos();
    }

    public void atualizar(Vendedor vendedor) {
        this.nome = vendedor.getNome();
        this.contatos = vendedor.getContatos();
    }

    public Vendedor toVendedor() {
        return new Vendedor(this.id, this.nome, this.contatos);
    }

}
