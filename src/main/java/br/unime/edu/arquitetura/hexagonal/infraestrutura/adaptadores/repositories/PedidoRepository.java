package br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.repositories;

import br.unime.edu.arquitetura.hexagonal.dominio.Pedido;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.repositories.PedidoRepositoryPort;
import br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.entidades.PedidoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PedidoRepository implements PedidoRepositoryPort {

    @Autowired
    private final SpringPedidoRepository springPedidoRepository;

    public PedidoRepository(SpringPedidoRepository springPedidoRepository) {
        this.springPedidoRepository = springPedidoRepository;
    }

    @Override
    public List<Pedido> buscarTodos() {
        List<PedidoEntity> pedidoEntities = this.springPedidoRepository.findAll();
        return pedidoEntities.stream().map(PedidoEntity::toPedido).collect(Collectors.toList());
    }

    @Override
    public Pedido buscarPeloId(Long id) {
        Optional<PedidoEntity> pedidoEntity = this.springPedidoRepository.findById(id);

        if (pedidoEntity.isPresent())
            return pedidoEntity.get().toPedido();

        throw new RuntimeException("Produto não existe");
    }

    @Override
    public void salvar(Pedido pedido) {
        PedidoEntity pedidoEntity;
        if (Objects.isNull(pedido.getId()))
            pedidoEntity = new PedidoEntity(pedido);
        else {
            pedidoEntity = this.springPedidoRepository.findById(pedido.getId()).get();
            pedidoEntity.atualizar(pedido);
        }

        this.springPedidoRepository.save(pedidoEntity);
    }
}
