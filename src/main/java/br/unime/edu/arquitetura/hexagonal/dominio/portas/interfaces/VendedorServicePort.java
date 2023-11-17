package br.unime.edu.arquitetura.hexagonal.dominio.portas.interfaces;

import br.unime.edu.arquitetura.hexagonal.dominio.dtos.EstoqueDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.VendedorDTO;
import javassist.NotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;


public interface VendedorServicePort {

    List<VendedorDTO> buscarVendedores();

    void criarVendedor(VendedorDTO vendedorDTO);

    //void atualizarPin(String sku, EstoqueDTO estoqueDTO) throws NotFoundException, ChangeSetPersister.NotFoundException;
}
