package br.unime.edu.arquitetura.hexagonal.aplicacao.adaptatores.controllers;

import br.unime.edu.arquitetura.hexagonal.dominio.dtos.AdministradorDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.EstoqueDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.ProdutoDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.interfaces.AdministradorServicePort;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.interfaces.ProdutoServicePort;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdministradorController {

    @Autowired
    private final AdministradorServicePort administradorServicePort;

    public AdministradorController(AdministradorServicePort administradorServicePort) {
        this.administradorServicePort = administradorServicePort;
    }

    @PostMapping
    void criarAdmin(@RequestBody AdministradorDTO administradorDTO) {
        administradorServicePort.criarAdmin(administradorDTO);
    }

    @GetMapping
    List<AdministradorDTO> getAdministradores() {
        return administradorServicePort.buscarAdministradores();
    }

}
