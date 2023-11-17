package br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.repositories;

import br.unime.edu.arquitetura.hexagonal.dominio.Administrador;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.repositories.AdministradorRepositoryPort;
import br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.entidades.AdministradorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AdministradorRepository implements AdministradorRepositoryPort {

    @Autowired
    private final SpringAdministradorRepository springAdministradorRepository;

    public AdministradorRepository(SpringAdministradorRepository springAdministradorRepository) {
        this.springAdministradorRepository = springAdministradorRepository;
    }

    @Override
    public List<Administrador> buscarTodos() {
        List<AdministradorEntity> produtoEntities = this.springAdministradorRepository.findAll();
        return produtoEntities.stream().map(AdministradorEntity::toAdministrador).collect(Collectors.toList());
    }

    @Override
    public Administrador buscarPeloId(Long id) {
        Optional<AdministradorEntity> adminEntity = this.springAdministradorRepository.findById(id);

        if (adminEntity.isPresent())
            return adminEntity.get().toAdministrador();

        throw new RuntimeException("O Administrador não existe");
    }

    @Override
    public void salvar(Administrador admin) {
        AdministradorEntity adminEntity;
        if (Objects.isNull(admin.getId()))
            adminEntity = new AdministradorEntity(admin);
        else {
            adminEntity = this.springAdministradorRepository.findById(admin.getId()).get();
            adminEntity.atualizar(admin);
        }

        this.springAdministradorRepository.save(adminEntity);
    }
}
