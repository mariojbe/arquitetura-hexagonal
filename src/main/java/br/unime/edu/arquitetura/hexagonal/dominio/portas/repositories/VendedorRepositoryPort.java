package br.unime.edu.arquitetura.hexagonal.dominio.portas.repositories;

import br.unime.edu.arquitetura.hexagonal.dominio.Produto;
import br.unime.edu.arquitetura.hexagonal.dominio.Vendedor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VendedorRepositoryPort {
    List<Vendedor> buscarTodos();

    Vendedor buscarPeloId(Long id);

    void salvar(Vendedor vendedor);
}
