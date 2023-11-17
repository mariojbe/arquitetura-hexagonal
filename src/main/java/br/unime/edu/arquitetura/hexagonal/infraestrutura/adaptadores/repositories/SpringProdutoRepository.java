package br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.repositories;

import br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.entidades.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
    Optional<ProdutoEntity> buscarPeloId(Long id);
}
