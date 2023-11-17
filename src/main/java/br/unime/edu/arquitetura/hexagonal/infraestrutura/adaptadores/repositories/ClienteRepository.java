package br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.repositories;

import br.unime.edu.arquitetura.hexagonal.dominio.Cliente;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.repositories.ClienteRepositoryPort;
import br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.entidades.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ClienteRepository implements ClienteRepositoryPort {

    @Autowired
    private final SpringClienteRepository springClienteRepository;

    public ClienteRepository(SpringClienteRepository springClienteRepository) {
        this.springClienteRepository = springClienteRepository;
    }

    @Override
    public List<Cliente> buscarTodos() {
        List<ClienteEntity> clienteEntities = this.springClienteRepository.findAll();
        return clienteEntities.stream().map(ClienteEntity::toCliente).collect(Collectors.toList());
    }

    @Override
    public Cliente buscarPeloId(Long id) {
        Optional<ClienteEntity> clienteEntity = this.springClienteRepository.findById(id);

        if (clienteEntity.isPresent())
            return clienteEntity.get().toCliente();

        throw new RuntimeException("O Cliente não existe!");
    }

    @Override
    public void salvar(Cliente cliente) {
        ClienteEntity clienteEntity;
        if (Objects.isNull(cliente.getId()))
            clienteEntity = new ClienteEntity(cliente);
        else {
            clienteEntity = this.springClienteRepository.findById(cliente.getId()).get();
            clienteEntity.atualizar(cliente);
        }

        this.springClienteRepository.save(clienteEntity);
    }
}
