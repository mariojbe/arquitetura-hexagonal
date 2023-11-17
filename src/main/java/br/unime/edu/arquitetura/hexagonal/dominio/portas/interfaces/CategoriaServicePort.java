package br.unime.edu.arquitetura.hexagonal.dominio.portas.interfaces;

import br.unime.edu.arquitetura.hexagonal.dominio.dtos.CategoriaDTO;
import org.springframework.stereotype.Service;

import java.util.List;



public interface CategoriaServicePort {

    List<CategoriaDTO> buscarCategorias();

    void criarCategoria(CategoriaDTO categoriaDTO);

}
