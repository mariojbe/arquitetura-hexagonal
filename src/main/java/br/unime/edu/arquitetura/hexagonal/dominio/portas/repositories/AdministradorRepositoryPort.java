package br.unime.edu.arquitetura.hexagonal.dominio.portas.repositories;

import br.unime.edu.arquitetura.hexagonal.dominio.Administrador;
import br.unime.edu.arquitetura.hexagonal.dominio.Produto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdministradorRepositoryPort {
    List<Administrador> buscarTodos();

    Administrador buscarPeloId(Long id);

    void salvar(Administrador administrador);
}
