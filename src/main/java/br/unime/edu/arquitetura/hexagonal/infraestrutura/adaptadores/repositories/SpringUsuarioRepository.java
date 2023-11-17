package br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.repositories;

import br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.entidades.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringUsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> buscarPeloId(Long id);
}
