package br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.repositories;

import br.unime.edu.arquitetura.hexagonal.dominio.Usuario;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.repositories.UsuarioRepositoryPort;
import br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.entidades.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UsuarioRepository implements UsuarioRepositoryPort {

    @Autowired
    private final SpringUsuarioRepository springUsuarioRepository;

    public UsuarioRepository(SpringUsuarioRepository springUsuarioRepository) {
        this.springUsuarioRepository = springUsuarioRepository;
    }

    @Override
    public List<Usuario> buscarTodos() {
        List<UsuarioEntity> usuarioEntities = this.springUsuarioRepository.findAll();
        return usuarioEntities.stream().map(UsuarioEntity::toUsuario).collect(Collectors.toList());
    }

    @Override
    public Usuario buscarPeloId(Long id) {
        Optional<UsuarioEntity> usuarioEntity = this.springUsuarioRepository.findById(id);

        if (usuarioEntity.isPresent())
            return usuarioEntity.get().toUsuario();

        throw new RuntimeException("Produto não existe");
    }

    @Override
    public void salvar(Usuario usuario) {
        UsuarioEntity usuarioEntity;
        if (Objects.isNull(usuario.getId()))
            usuarioEntity = new UsuarioEntity(usuario);
        else {
            usuarioEntity = this.springUsuarioRepository.findById(usuario.getId()).get();
            usuarioEntity.atualizar(usuario);
        }

        this.springUsuarioRepository.save(usuarioEntity);
    }
}
