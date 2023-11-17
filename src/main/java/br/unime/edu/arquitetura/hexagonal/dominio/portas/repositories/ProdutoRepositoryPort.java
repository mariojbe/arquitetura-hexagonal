package br.unime.edu.arquitetura.hexagonal.dominio.portas.repositories;

import br.unime.edu.arquitetura.hexagonal.dominio.Produto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProdutoRepositoryPort {
    List<Produto> buscarTodos();

    Produto buscarPeloId(Long id);

    void salvar(Produto produto);
}
