package br.unime.edu.arquitetura.hexagonal.dominio.portas.repositories;

import br.unime.edu.arquitetura.hexagonal.dominio.Produto;
import br.unime.edu.arquitetura.hexagonal.dominio.ProdutoPreco;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProdutoPrecoRepositoryPort {
    List<ProdutoPreco> buscarTodos();

    ProdutoPreco buscarPeloId(Long id);

    void salvar(ProdutoPreco produtoPreco);
}
