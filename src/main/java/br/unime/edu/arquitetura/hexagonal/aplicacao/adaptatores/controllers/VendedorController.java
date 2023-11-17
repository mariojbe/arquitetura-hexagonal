package br.unime.edu.arquitetura.hexagonal.aplicacao.adaptatores.controllers;

import br.unime.edu.arquitetura.hexagonal.dominio.dtos.EstoqueDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.ProdutoDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.VendedorDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.interfaces.VendedorServicePort;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vendedores")
public class VendedorController {

    @Autowired
    private final VendedorServicePort vendedorServicePort;

    public VendedorController(VendedorServicePort vendedorServicePort) {
        this.vendedorServicePort = vendedorServicePort;
    }

    @PostMapping
    void criarVendedor(@RequestBody VendedorDTO vendedorDTO) {
        vendedorServicePort.criarVendedor(vendedorDTO);
    }

    @GetMapping
    List<VendedorDTO> getVendedores() {
        return vendedorServicePort.buscarVendedores();
    }

}
