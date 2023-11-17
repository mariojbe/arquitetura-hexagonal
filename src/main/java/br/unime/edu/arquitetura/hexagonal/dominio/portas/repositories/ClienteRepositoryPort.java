package br.unime.edu.arquitetura.hexagonal.dominio.portas.repositories;

import br.unime.edu.arquitetura.hexagonal.dominio.Cliente;
import br.unime.edu.arquitetura.hexagonal.dominio.Produto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClienteRepositoryPort {
    List<Cliente> buscarTodos();

    Cliente buscarPeloId(Long id);

    void salvar(Cliente cliente);
}
