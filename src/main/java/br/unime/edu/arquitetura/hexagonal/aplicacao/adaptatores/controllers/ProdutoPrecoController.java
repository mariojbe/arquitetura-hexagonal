package br.unime.edu.arquitetura.hexagonal.aplicacao.adaptatores.controllers;

import br.unime.edu.arquitetura.hexagonal.dominio.dtos.EstoqueDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.ProdutoPrecoDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.interfaces.ProdutoPrecoServicePort;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("preco")
public class ProdutoPrecoController {

    @Autowired
    private final ProdutoPrecoServicePort produtoPrecoServicePort;

    public ProdutoPrecoController(ProdutoPrecoServicePort produtoPrecoServicePort) {
        this.produtoPrecoServicePort = produtoPrecoServicePort;
    }

    @PostMapping
    void criarPreco(@RequestBody ProdutoPrecoDTO produtoPrecoDTO) {
        produtoPrecoServicePort.criarPreco(produtoPrecoDTO);
    }

    @GetMapping
    List<ProdutoPrecoDTO> getPrecos() {
        return produtoPrecoServicePort.buscarPrecos();
    }

}
