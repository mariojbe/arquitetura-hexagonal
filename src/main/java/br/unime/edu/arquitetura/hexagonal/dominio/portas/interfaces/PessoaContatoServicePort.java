package br.unime.edu.arquitetura.hexagonal.dominio.portas.interfaces;

import br.unime.edu.arquitetura.hexagonal.dominio.dtos.EstoqueDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.PessoaContatoDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.ProdutoDTO;
import javassist.NotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;


public interface PessoaContatoServicePort {

    List<PessoaContatoDTO> buscarContatos();

    void criarContato(PessoaContatoDTO pessoaContatoDTO);

    //void atualizarEstoque(String sku, EstoqueDTO estoqueDTO) throws NotFoundException, ChangeSetPersister.NotFoundException;
}
