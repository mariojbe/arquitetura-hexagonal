package br.unime.edu.arquitetura.hexagonal.dominio.adaptadores.services;

import br.unime.edu.arquitetura.hexagonal.dominio.PessoaContato;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.PessoaContatoDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.interfaces.PessoaContatoServicePort;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.repositories.PessoaContatoRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Primary
public class PessoaContatoServiceImp implements PessoaContatoServicePort {


    private final PessoaContatoRepositoryPort pessoaContatoRepository;

    @Autowired
    public PessoaContatoServiceImp(@Qualifier("pessoaContatoRepository") PessoaContatoRepositoryPort pessoaContatoRepository) {
        this.pessoaContatoRepository = pessoaContatoRepository;
    }

    @Override
    public void criarContato(PessoaContatoDTO pessoaContatoDTO) {
        PessoaContato pessoaContato = new PessoaContato(pessoaContatoDTO);
        this.pessoaContatoRepository.salvar(pessoaContato);
    }

    @Override
    public List<PessoaContatoDTO> buscarContatos() {
        List<PessoaContato> produtos = this.pessoaContatoRepository.buscarTodos();
        List<PessoaContatoDTO> pessoaContatoDTOS = produtos.stream().map(PessoaContato::toPessoaContatoDTO).collect(Collectors.toList());
        return pessoaContatoDTOS;
    }

    /*@Override
    public void atualizarEstoque(String sku, EstoqueDTO estoqueDTO) throws ChangeSetPersister.NotFoundException {
        Produto produto = this.produtoRepository.buscarPeloSku(sku);

        if (Objects.isNull(produto))
            throw new ChangeSetPersister.NotFoundException();

        produto.atualizarEstoque(estoqueDTO.getQuantidade());

        this.produtoRepository.salvar(produto);
    }*/
}