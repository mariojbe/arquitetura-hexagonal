package br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.entidades;

import br.unime.edu.arquitetura.hexagonal.dominio.Categoria;
import br.unime.edu.arquitetura.hexagonal.dominio.Cliente;

import javax.persistence.*;

@Entity
@DiscriminatorValue("cliente")// é usado para definir o valor discriminador para cada subclasse.
@Table(name = "cliente")
public class ClienteEntity extends UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    public ClienteEntity() {
    }

    public ClienteEntity(Cliente cliente) {
        this.nome = cliente.getNome();
    }

    public void atualizar(Cliente cliente) {
        this.nome = cliente.getNome();
    }

    public Cliente toCliente() {
        return new Cliente(this.id, this.nome);
    }

}
