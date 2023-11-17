package br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.repositories;

import br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.entidades.ProdutoEntity;
import br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.entidades.VendedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringVendedorRepository extends JpaRepository<VendedorEntity, Long> {
    Optional<VendedorEntity> buscarPeloId(Long id);
}
