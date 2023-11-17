package br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.repositories;

import br.unime.edu.arquitetura.hexagonal.dominio.PessoaContato;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.repositories.PessoaContatoRepositoryPort;
import br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.entidades.PessoaContatoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PessoaContatoRepository implements PessoaContatoRepositoryPort {

    @Autowired
    private final SpringPessoaContatoRepository springPessoaContatoRepository;

    public PessoaContatoRepository(SpringPessoaContatoRepository springPessoaContatoRepository) {
        this.springPessoaContatoRepository = springPessoaContatoRepository;
    }

    @Override
    public List<PessoaContato> buscarTodos() {
        List<PessoaContatoEntity> pessoaContatoEntities = this.springPessoaContatoRepository.findAll();
        return pessoaContatoEntities.stream().map(PessoaContatoEntity::toPessoaContato).collect(Collectors.toList());
    }

    @Override
    public PessoaContato buscarPeloId(Long id) {
        Optional<PessoaContatoEntity> pessoaContatoEntity = this.springPessoaContatoRepository.findById(id);

        if (pessoaContatoEntity.isPresent()) return pessoaContatoEntity.get().toPessoaContato();

        throw new RuntimeException("Contato não localizado!");
    }

    @Override
    public void salvar(PessoaContato pessoaContato) {
        PessoaContatoEntity pessoaContatoEntity;
        if (Objects.isNull(pessoaContato.getId())) pessoaContatoEntity = new PessoaContatoEntity(pessoaContato);
        else {
            pessoaContatoEntity = this.springPessoaContatoRepository.findById(pessoaContato.getId()).get();
            pessoaContatoEntity.atualizar(pessoaContato);
        }

        this.springPessoaContatoRepository.save(pessoaContatoEntity);
    }
}
