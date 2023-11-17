package br.unime.edu.arquitetura.hexagonal.dominio;

import br.unime.edu.arquitetura.hexagonal.dominio.dtos.AdministradorDTO;
import br.unime.edu.arquitetura.hexagonal.dominio.dtos.VendedorDTO;

public class Administrador extends Usuario {

    private Long id;
    private Integer pin;

    public Administrador() {
    }

    public Administrador(Long id, Integer pin) {
        this.id = id;
        this.pin = pin;
    }

    public Long getId() {
        return id;
    }

    public Integer getPin() {
        return pin;
    }

    public Administrador(AdministradorDTO administradorDTO) {
        this.pin = administradorDTO.getPin();
    }

    public AdministradorDTO toAdministradorDTO() {
        return new AdministradorDTO(this.pin);
    }

}
