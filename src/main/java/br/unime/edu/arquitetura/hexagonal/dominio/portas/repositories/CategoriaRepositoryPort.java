package br.unime.edu.arquitetura.hexagonal.dominio.portas.repositories;

import br.unime.edu.arquitetura.hexagonal.dominio.Categoria;

import java.util.List;
import java.util.UUID;

public interface CategoriaRepositoryPort {
    List<Categoria> buscarTodas();

    Categoria buscarPorId(Long id);

    void salvar(Categoria categoria);
}
