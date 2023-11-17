package br.unime.edu.arquitetura.hexagonal.dominio.portas.interfaces;

import br.unime.edu.arquitetura.hexagonal.dominio.dtos.EstoqueDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.PedidoDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.ProdutoDTO;
import javassist.NotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;


public interface PedidoServicePort {

    List<PedidoDTO> buscarPedidos();

    void criarPedido(PedidoDTO pedidoDTO);
}
