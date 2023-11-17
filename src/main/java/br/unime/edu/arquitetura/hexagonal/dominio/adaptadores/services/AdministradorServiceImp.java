package br.unime.edu.arquitetura.hexagonal.dominio.adaptadores.services;

import br.unime.edu.arquitetura.hexagonal.dominio.Administrador;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.AdministradorDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.interfaces.AdministradorServicePort;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.repositories.AdministradorRepositoryPort;
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
public class AdministradorServiceImp implements AdministradorServicePort {


    private final AdministradorRepositoryPort administradorRepository;

    @Autowired
    public AdministradorServiceImp(@Qualifier("administradorRepository") AdministradorRepositoryPort administradorRepository) {
        this.administradorRepository = administradorRepository;
    }

    @Override
    public void criarAdmin(AdministradorDTO administradorDTO) {
        Administrador admin = new Administrador(administradorDTO);
        this.administradorRepository.salvar(admin);
    }

    @Override
    public List<AdministradorDTO> buscarAdministradores() {
        List<Administrador> administradorres = this.administradorRepository.buscarTodos();
        List<AdministradorDTO> administradorDTOS = administradorres.stream().map(Administrador::toAdministradorDTO).collect(Collectors.toList());
        return administradorDTOS;
    }

}