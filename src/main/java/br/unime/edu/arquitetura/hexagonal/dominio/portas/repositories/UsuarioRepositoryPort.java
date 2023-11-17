package br.unime.edu.arquitetura.hexagonal.dominio.portas.repositories;

import br.unime.edu.arquitetura.hexagonal.dominio.Produto;
import br.unime.edu.arquitetura.hexagonal.dominio.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuarioRepositoryPort {
    List<Usuario> buscarTodos();

    Usuario buscarPeloId(Long id);

    void salvar(Usuario usuario);
}
