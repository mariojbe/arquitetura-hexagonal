package br.unime.edu.arquitetura.hexagonal.dominio;

import br.unime.edu.arquitetura.hexagonal.dominio.dtos.ClienteDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.ProdutoDTO;

public class Cliente extends Usuario {

    private Long id;
    private String profissao;

    public Cliente() {
    }

    public Cliente(Long id, String profissao) {
        this.id = id;
        this.profissao = profissao;
    }

    public Long getId() {
        return id;
    }

    public String getProfissao() {
        return profissao;
    }

    public Cliente(ClienteDTO clienteDTO) {
        this.profissao = clienteDTO.getProfissao();
    }

    /*public void atualizarEstoque(double quantidade) {
        this.quantidade = quantidade;
    }*/

    public ClienteDTO toClienteDTO() {
        return new ClienteDTO(this.profissao);
    }

}
