package br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.entidades;

import br.unime.edu.arquitetura.hexagonal.dominio.Administrador;
import br.unime.edu.arquitetura.hexagonal.dominio.Produto;

import javax.persistence.*;

@Entity
@DiscriminatorValue("administrador")// é usado para definir o valor discriminador para cada subclasse.
@Table(name = "administrador")
public class AdministradorEntity extends UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer pin;

    public AdministradorEntity() {
    }

    public AdministradorEntity(Administrador admin) {
        this.pin = admin.getPin();
    }

    public void atualizar(Administrador admin) {
        this.pin = admin.getPin();
    }

    public Administrador toAdministrador() {
        return new Administrador(this.id, this.pin);
    }
}
