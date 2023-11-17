package br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.entidades;

import br.unime.edu.arquitetura.hexagonal.dominio.Usuario;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
@DiscriminatorColumn(name = "tipo_usuario")//especifica a coluna usada para diferenciar entre os tipos de usuários.
@Table(name = "usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;

    public UsuarioEntity() {
    }

    public UsuarioEntity(Usuario usuario) {
        this.nome = usuario.getNome();
        this.email = usuario.getNome();
        this.senha = usuario.getSenha();
    }

    public void atualizar(Usuario usuario) {
        this.nome = usuario.getNome();
        this.email = usuario.getNome();
        this.senha = usuario.getSenha();
    }

    public Usuario toUsuario() {
        return new Usuario(this.id, this.nome, this.email, this.senha);
    }
}
