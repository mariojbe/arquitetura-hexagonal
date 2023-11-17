package br.unime.edu.arquitetura.hexagonal.dominio.adaptadores.services;

import br.unime.edu.arquitetura.hexagonal.dominio.ProdutoPreco;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.ProdutoPrecoDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.interfaces.ProdutoPrecoServicePort;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.repositories.ProdutoPrecoRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
@Primary
public class ProdutoPrecoServiceImp implements ProdutoPrecoServicePort {


    private final ProdutoPrecoRepositoryPort produtoPrecoRepository;

    @Autowired
    public ProdutoPrecoServiceImp(@Qualifier("produtoPrecoRepository") ProdutoPrecoRepositoryPort produtoPrecoRepository) {
        this.produtoPrecoRepository = produtoPrecoRepository;
    }

    @Override
    public void criarPreco(ProdutoPrecoDTO produtoPrecoDTO) {
        ProdutoPreco produtoPreco = new ProdutoPreco(produtoPrecoDTO);
        this.produtoPrecoRepository.salvar(produtoPreco);
    }

    @Override
    public List<ProdutoPrecoDTO> buscarPrecos() {
        List<ProdutoPreco> produtoPreco = this.produtoPrecoRepository.buscarTodos();
        List<ProdutoPrecoDTO> produtoPrecoDTOS = produtoPreco.stream().map(ProdutoPreco::toProdutoPrecoDTO).collect(Collectors.toList());
        return produtoPrecoDTOS;
    }

}