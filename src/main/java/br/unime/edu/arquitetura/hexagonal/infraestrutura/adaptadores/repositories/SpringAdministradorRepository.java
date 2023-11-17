package br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.repositories;

import br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.entidades.AdministradorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringAdministradorRepository extends JpaRepository<AdministradorEntity, Long> {
    Optional<AdministradorEntity> buscarPeloId(Long id);
}
