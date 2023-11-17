package br.unime.edu.arquitetura.hexagonal.dominio.portas.repositories;

import br.unime.edu.arquitetura.hexagonal.dominio.PessoaContato;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PessoaContatoRepositoryPort {
    List<PessoaContato> buscarTodos();

    PessoaContato buscarPeloId(Long id);

    void salvar(PessoaContato pessoaContato);
}
