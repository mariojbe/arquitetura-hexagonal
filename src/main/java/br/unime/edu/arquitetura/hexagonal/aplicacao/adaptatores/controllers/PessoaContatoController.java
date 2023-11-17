package br.unime.edu.arquitetura.hexagonal.aplicacao.adaptatores.controllers;

import br.unime.edu.arquitetura.hexagonal.dominio.dtos.EstoqueDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.PessoaContatoDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.ProdutoDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.interfaces.PessoaContatoServicePort;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contatos")
public class PessoaContatoController {

    @Autowired
    private final PessoaContatoServicePort pessoaContatoServicePort;

    public PessoaContatoController(PessoaContatoServicePort pessoaContatoServicePort) {
        this.pessoaContatoServicePort = pessoaContatoServicePort;
    }

    @PostMapping
    void criarContato(@RequestBody PessoaContatoDTO pessoaContatoDTO) {
        pessoaContatoServicePort.criarContato(pessoaContatoDTO);
    }

    @GetMapping
    List<PessoaContatoDTO> getContatos() {
        return pessoaContatoServicePort.buscarContatos();
    }

}

