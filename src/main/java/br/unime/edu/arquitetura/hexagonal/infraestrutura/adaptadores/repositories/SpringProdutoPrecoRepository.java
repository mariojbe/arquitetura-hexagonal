package br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.repositories;

import br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.entidades.ProdutoEntity;
import br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.entidades.ProdutoPrecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringProdutoPrecoRepository extends JpaRepository<ProdutoPrecoEntity, Long> {
    Optional<ProdutoPrecoEntity> buscarPeloId(Long id);
}
