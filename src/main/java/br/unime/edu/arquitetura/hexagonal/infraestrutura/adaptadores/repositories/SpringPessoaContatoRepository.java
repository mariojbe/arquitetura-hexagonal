package br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.repositories;

import br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.entidades.PessoaContatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringPessoaContatoRepository extends JpaRepository<PessoaContatoEntity, Long> {
    Optional<PessoaContatoEntity> buscarPeloId(Long id);
}
