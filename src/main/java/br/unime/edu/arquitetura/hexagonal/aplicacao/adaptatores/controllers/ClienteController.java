package br.unime.edu.arquitetura.hexagonal.aplicacao.adaptatores.controllers;

import br.unime.edu.arquitetura.hexagonal.dominio.dtos.ClienteDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.EstoqueDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.ProdutoDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.interfaces.ClienteServicePort;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.interfaces.ProdutoServicePort;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private final ClienteServicePort clienteServicePort;

    public ClienteController(ClienteServicePort clienteServicePort) {
        this.clienteServicePort = clienteServicePort;
    }

    @PostMapping
    void criarClientes(@RequestBody ClienteDTO clienteDTO) {
        clienteServicePort.criarCliente(clienteDTO);
    }

    @GetMapping
    List<ClienteDTO> getClientes() {
        return clienteServicePort.buscarClientes();
    }
}
