package br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.repositories;

import br.unime.edu.arquitetura.hexagonal.dominio.ProdutoPreco;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.repositories.ProdutoPrecoRepositoryPort;
import br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.entidades.ProdutoPrecoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProdutoPrecoRepository implements ProdutoPrecoRepositoryPort {

    @Autowired
    private final SpringProdutoPrecoRepository springProdutoPrecoRepository;

    public ProdutoPrecoRepository(SpringProdutoPrecoRepository springProdutoPrecoRepository) {
        this.springProdutoPrecoRepository = springProdutoPrecoRepository;
    }

    @Override
    public List<ProdutoPreco> buscarTodos() {
        List<ProdutoPrecoEntity> produtoPrecoEntities = this.springProdutoPrecoRepository.findAll();
        return produtoPrecoEntities.stream().map(ProdutoPrecoEntity::toProdutoPreco).collect(Collectors.toList());
    }

    @Override
    public ProdutoPreco buscarPeloId(Long id) {
        Optional<ProdutoPrecoEntity> produtoPrecoEntity = this.springProdutoPrecoRepository.findById(id);

        if (produtoPrecoEntity.isPresent())
            return produtoPrecoEntity.get().toProdutoPreco();

        throw new RuntimeException("Preço não Localizado!");
    }

    @Override
    public void salvar(ProdutoPreco produtoPreco) {
        ProdutoPrecoEntity produtoPrecoEntity;
        if (Objects.isNull(produtoPreco.getId()))
            produtoPrecoEntity = new ProdutoPrecoEntity(produtoPreco);
        else {
            produtoPrecoEntity = this.springProdutoPrecoRepository.findById(produtoPreco.getId()).get();
            produtoPrecoEntity.atualizar(produtoPreco);
        }

        this.springProdutoPrecoRepository.save(produtoPrecoEntity);
    }
}
