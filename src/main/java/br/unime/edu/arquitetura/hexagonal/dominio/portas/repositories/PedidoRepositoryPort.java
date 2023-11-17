package br.unime.edu.arquitetura.hexagonal.dominio.portas.repositories;

import br.unime.edu.arquitetura.hexagonal.dominio.Pedido;
import br.unime.edu.arquitetura.hexagonal.dominio.Produto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PedidoRepositoryPort {
    List<Pedido> buscarTodos();

    Pedido buscarPeloId(Long id);

    void salvar(Pedido pedido);
}
