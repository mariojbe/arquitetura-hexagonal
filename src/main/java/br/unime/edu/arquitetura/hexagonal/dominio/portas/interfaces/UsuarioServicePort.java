package br.unime.edu.arquitetura.hexagonal.dominio.portas.interfaces;

import br.unime.edu.arquitetura.hexagonal.dominio.dtos.EstoqueDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.ProdutoDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.UsuarioDTO;
import javassist.NotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;


public interface UsuarioServicePort {

    List<UsuarioDTO> buscarUsuarios();

    void criarUsuario(UsuarioDTO usuarioDTO);

    //void atualizarEstoque(String sku, EstoqueDTO estoqueDTO) throws NotFoundException, ChangeSetPersister.NotFoundException;
}
