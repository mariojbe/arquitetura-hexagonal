package br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.entidades;

import br.unime.edu.arquitetura.hexagonal.dominio.PessoaContato;
import br.unime.edu.arquitetura.hexagonal.dominio.Produto;
import br.unime.edu.arquitetura.hexagonal.dominio.Vendedor;

import javax.persistence.*;

@Entity
@Table(name = "pessoa_contato")
public class PessoaContatoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String telefone;
    private String email;
    private String whatsapp;

    @ManyToOne // @ManyToOne Varios contatos para um vendedor
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;

    public PessoaContatoEntity() {
    }

    public PessoaContatoEntity(PessoaContato pessoaContato) {
        this.telefone = pessoaContato.getTelefone();
        this.email = pessoaContato.getEmail();
        this.whatsapp = pessoaContato.getWhatsapp();
        this.vendedor = pessoaContato.getVendedor();
    }

    public void atualizar(PessoaContato pessoaContato) {
        this.telefone = pessoaContato.getTelefone();
        this.email = pessoaContato.getEmail();
        this.whatsapp = pessoaContato.getWhatsapp();
        this.vendedor = pessoaContato.getVendedor();
    }

    public PessoaContato toPessoaContato() {
        return new PessoaContato(this.id, this.telefone, this.email, this.whatsapp, this.vendedor);
    }
}
