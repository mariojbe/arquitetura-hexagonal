package br.unime.edu.arquitetura.hexagonal.dominio.adaptadores.services;

import br.unime.edu.arquitetura.hexagonal.dominio.Vendedor;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.VendedorDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.interfaces.VendedorServicePort;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.repositories.VendedorRepositoryPort;
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
public class VendedorServiceImp implements VendedorServicePort {


    private final VendedorRepositoryPort vendedorRepository;

    @Autowired
    public VendedorServiceImp(@Qualifier("vendedorRepository") VendedorRepositoryPort vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    @Override
    public void criarVendedor(VendedorDTO vendedorDTO) {
        Vendedor vendedor = new Vendedor(vendedorDTO);
        this.vendedorRepository.salvar(vendedor);
    }

    @Override
    public List<VendedorDTO> buscarVendedores() {
        List<Vendedor> vendedores = this.vendedorRepository.buscarTodos();
        List<VendedorDTO> vendedorDTOS = vendedores.stream().map(Vendedor::toVendedorDTO).collect(Collectors.toList());
        return vendedorDTOS;
    }

    /*@Override
    public void atualizarEstoque(String sku, EstoqueDTO estoqueDTO) throws ChangeSetPersister.NotFoundException {
        Produto produto = this.produtoRepository.buscarPeloSku(sku);

        if (Objects.isNull(produto)) throw new ChangeSetPersister.NotFoundException();

        produto.atualizarEstoque(estoqueDTO.getQuantidade());

        this.produtoRepository.salvar(produto);
    }*/
}