package br.unime.edu.arquitetura.hexagonal.dominio.dtos;

public class ClienteDTO {
    private String profissao;

    public ClienteDTO() {
        super();
    }

    public ClienteDTO(String profissao) {
        this.profissao = profissao;
    }

    public String getProfissao() {
        return profissao;
    }

}
