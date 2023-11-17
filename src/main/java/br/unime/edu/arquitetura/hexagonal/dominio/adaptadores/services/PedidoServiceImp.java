package br.unime.edu.arquitetura.hexagonal.dominio.adaptadores.services;

import br.unime.edu.arquitetura.hexagonal.dominio.Pedido;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.PedidoDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.interfaces.PedidoServicePort;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.repositories.PedidoRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Primary
public class PedidoServiceImp implements PedidoServicePort {


    private final PedidoRepositoryPort pedidoRepository;

    @Autowired
    public PedidoServiceImp(@Qualifier("pedidoRepository") PedidoRepositoryPort pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public void criarPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido(pedidoDTO);
        this.pedidoRepository.salvar(pedido);
    }

    @Override
    public List<PedidoDTO> buscarPedidos() {
        List<Pedido> pedidos = this.pedidoRepository.buscarTodos();
        List<PedidoDTO> pedidoDTOS = pedidos.stream().map(Pedido::toPedidoDTO).collect(Collectors.toList());
        return pedidoDTOS;
    }
}