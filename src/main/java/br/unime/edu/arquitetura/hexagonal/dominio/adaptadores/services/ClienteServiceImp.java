package br.unime.edu.arquitetura.hexagonal.dominio.adaptadores.services;

import br.unime.edu.arquitetura.hexagonal.dominio.Cliente;
import br.unime.edu.arquitetura.hexagonal.dominio.Produto;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.ClienteDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.EstoqueDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.ProdutoDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.interfaces.ClienteServicePort;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.repositories.ClienteRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
@Primary
public class ClienteServiceImp implements ClienteServicePort {


    private final ClienteRepositoryPort clienteRepository;

    @Autowired
    public ClienteServiceImp(@Qualifier("clienteRepository") ClienteRepositoryPort clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void criarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente(clienteDTO);
        this.clienteRepository.salvar(cliente);
    }

    @Override
    public List<ClienteDTO> buscarClientes() {
        List<Cliente> clientes = this.clienteRepository.buscarTodos();
        List<ClienteDTO> clienteDTOS = clientes.stream().map(Cliente::toClienteDTO).collect(Collectors.toList());
        return clienteDTOS;
    }

    /*@Override
    public void atualizarEstoque(String sku, EstoqueDTO estoqueDTO) throws ChangeSetPersister.NotFoundException {
        Produto produto = this.produtoRepository.buscarPeloSku(sku);

        if (Objects.isNull(produto))
            throw new ChangeSetPersister.NotFoundException();

        produto.atualizarEstoque(estoqueDTO.getQuantidade());

        this.produtoRepository.salvar(produto);
    }*/
}