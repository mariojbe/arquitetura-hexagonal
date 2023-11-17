package br.unime.edu.arquitetura.hexagonal.dominio.portas.interfaces;

import br.unime.edu.arquitetura.hexagonal.dominio.dtos.EstoqueDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.ProdutoDTO;
import javassist.NotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProdutoServicePort {

    List<ProdutoDTO> buscarProdutos();

    void criarProduto(ProdutoDTO produtoDTO);

    void atualizarEstoque(Long id, EstoqueDTO estoqueDTO) throws NotFoundException, ChangeSetPersister.NotFoundException;
}
