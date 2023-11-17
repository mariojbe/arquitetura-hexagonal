package br.unime.edu.arquitetura.hexagonal.dominio.portas.interfaces;

import br.unime.edu.arquitetura.hexagonal.dominio.dtos.AdministradorDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.EstoqueDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.ProdutoDTO;
import javassist.NotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;


public interface AdministradorServicePort {

    List<AdministradorDTO> buscarAdministradores();

    void criarAdmin(AdministradorDTO adminDTO);

    //void atualizarAdmin(String id, AdministradorDTO adminDTO) throws NotFoundException, ChangeSetPersister.NotFoundException;
}
