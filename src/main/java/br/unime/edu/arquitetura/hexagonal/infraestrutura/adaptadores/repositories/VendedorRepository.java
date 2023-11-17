package br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.repositories;

import br.unime.edu.arquitetura.hexagonal.dominio.Vendedor;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.repositories.VendedorRepositoryPort;
import br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.entidades.VendedorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class VendedorRepository implements VendedorRepositoryPort {

    @Autowired
    private final SpringVendedorRepository springVendedorRepository;

    public VendedorRepository(SpringVendedorRepository springVendedorRepository) {
        this.springVendedorRepository = springVendedorRepository;
    }

    @Override
    public List<Vendedor> buscarTodos() {
        List<VendedorEntity> produtoEntities = this.springVendedorRepository.findAll();
        return produtoEntities.stream().map(VendedorEntity::toVendedor).collect(Collectors.toList());
    }

    @Override
    public Vendedor buscarPeloId(Long id) {
        Optional<VendedorEntity> vendedorEntity = this.springVendedorRepository.findById(id);

        if (vendedorEntity.isPresent()) return vendedorEntity.get().toVendedor();

        throw new RuntimeException("Vendedor não localizado!");
    }

    @Override
    public void salvar(Vendedor vendedor) {
        VendedorEntity vendedorEntity;
        if (Objects.isNull(vendedor.getId())) vendedorEntity = new VendedorEntity(vendedor);
        else {
            vendedorEntity = this.springVendedorRepository.findById(vendedor.getId()).get();
            vendedorEntity.atualizar(vendedor);
        }

        this.springVendedorRepository.save(vendedorEntity);
    }
}
