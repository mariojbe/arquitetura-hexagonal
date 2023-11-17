package br.unime.edu.arquitetura.hexagonal.dominio.adaptadores.services;

import br.unime.edu.arquitetura.hexagonal.dominio.Categoria;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.CategoriaDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.interfaces.CategoriaServicePort;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.repositories.CategoriaRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Primary
public class CategoriaServiceImp implements CategoriaServicePort {

    private final CategoriaRepositoryPort categoriaRepository;

    @Autowired
    public CategoriaServiceImp(@Qualifier("categoriaRepository") CategoriaRepositoryPort categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public void criarCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria(categoriaDTO);
        this.categoriaRepository.salvar(categoria);
    }

    @Override
    public List<CategoriaDTO> buscarCategorias() {
        List<Categoria> categorias = this.categoriaRepository.buscarTodas();
        List<CategoriaDTO> categoriaDTOS = categorias.stream().map(Categoria::toCategoriaDTO).collect(Collectors.toList());
        return categoriaDTOS;
    }
}