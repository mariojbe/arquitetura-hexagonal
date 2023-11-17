package br.unime.edu.arquitetura.hexagonal.aplicacao.adaptatores.controllers;

import br.unime.edu.arquitetura.hexagonal.dominio.dtos.EstoqueDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.ProdutoDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.UsuarioDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.interfaces.ProdutoServicePort;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.interfaces.UsuarioServicePort;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private final UsuarioServicePort usuarioServicePort;

    public UsuarioController(UsuarioServicePort usuarioServicePort) {
        this.usuarioServicePort = usuarioServicePort;
    }

    @PostMapping
    void criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        usuarioServicePort.criarUsuario(usuarioDTO);
    }

    @GetMapping
    List<UsuarioDTO> getUsuarios() {
        return usuarioServicePort.buscarUsuarios();
    }

}
