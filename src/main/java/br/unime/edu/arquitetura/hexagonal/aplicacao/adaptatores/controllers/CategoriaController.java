package br.unime.edu.arquitetura.hexagonal.aplicacao.adaptatores.controllers;

import br.unime.edu.arquitetura.hexagonal.dominio.dtos.CategoriaDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.interfaces.CategoriaServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categorias")
public class CategoriaController {

    @Autowired
    private final CategoriaServicePort categoriaServicePort;

    public CategoriaController(CategoriaServicePort categoriaServicePort) {
        this.categoriaServicePort = categoriaServicePort;
    }

    @PostMapping
    void criarCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        categoriaServicePort.criarCategoria(categoriaDTO);
    }

    @GetMapping
    List<CategoriaDTO> getCategorias() {
        return categoriaServicePort.buscarCategorias();
    }
}
