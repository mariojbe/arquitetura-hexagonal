package br.unime.edu.arquitetura.hexagonal.dominio.portas.interfaces;

import br.unime.edu.arquitetura.hexagonal.dominio.dtos.EstoqueDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.ProdutoDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.ProdutoPrecoDTO;
import javassist.NotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;


public interface ProdutoPrecoServicePort {

    List<ProdutoPrecoDTO> buscarPrecos();

    void criarPreco(ProdutoPrecoDTO ProdutoPrecoDTO);

}
