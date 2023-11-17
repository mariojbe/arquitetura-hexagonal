package br.unime.edu.arquitetura.hexagonal.dominio.adaptadores.services;

import br.unime.edu.arquitetura.hexagonal.dominio.Usuario;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.UsuarioDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.interfaces.UsuarioServicePort;
import br.unime.edu.arquitetura.hexagonal.dominio.portas.repositories.UsuarioRepositoryPort;
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
public class UsuarioServiceImp implements UsuarioServicePort {


    private final UsuarioRepositoryPort usuarioRepository;

    @Autowired
    public UsuarioServiceImp(@Qualifier("usuarioRepository") UsuarioRepositoryPort usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void criarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(usuarioDTO);
        this.usuarioRepository.salvar(usuario);
    }

    @Override
    public List<UsuarioDTO> buscarUsuarios() {
        List<Usuario> produtos = this.usuarioRepository.buscarTodos();
        List<UsuarioDTO> produtoDTOS = produtos.stream().map(Usuario::toUsuarioDTO).collect(Collectors.toList());
        return produtoDTOS;
    }

    /*@Override
    public void atualizarEstoque(String sku, EstoqueDTO estoqueDTO) throws ChangeSetPersister.NotFoundException {
        Produto produto = this.produtoRepository.buscarPeloSku(sku);

        if (Objects.isNull(produto))
            throw new ChangeSetPersister.NotFoundException();

        produto.atualizarEstoque(estoqueDTO.getQuantidade());

        this.produtoRepository.salvar(produto);
    }*/
}