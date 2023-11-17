package br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.repositories;

import br.unime.edu.arquitetura.hexagonal.dominio.Categoria;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.repositories.CategoriaRepositoryPort;
import br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.entidades.CategoriaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CategoriaRepository implements CategoriaRepositoryPort {

    @Autowired
    private final SpringCategoriaRepository springCategoriaRepository;

    @Autowired
    public CategoriaRepository(@Qualifier("springCategoriaRepository") SpringCategoriaRepository springCategoriaRepository) {
        this.springCategoriaRepository = springCategoriaRepository;
    }

    @Override
    public List<Categoria> buscarTodas() {
        List<CategoriaEntity> categoriaEntities = this.springCategoriaRepository.findAll();
        return categoriaEntities.stream().map(CategoriaEntity::toCategoria).collect(Collectors.toList());
    }

    @Override
    public Categoria buscarPorId(Long id) {
        Optional<CategoriaEntity> categoriaEntity = this.springCategoriaRepository.findById(id);

        if (categoriaEntity.isPresent()) return categoriaEntity.get().toCategoria();

        throw new RuntimeException("Categoria não existe");
    }

    @Override
    public void salvar(Categoria categoria) {
        CategoriaEntity categoriaEntity;
        if (Objects.isNull(categoria.getId())) categoriaEntity = new CategoriaEntity(categoria);
        else {
            categoriaEntity = this.springCategoriaRepository.findById(categoria.getId()).get();
            categoriaEntity.atualizar(categoria);
        }

        this.springCategoriaRepository.save(categoriaEntity);
    }
}
