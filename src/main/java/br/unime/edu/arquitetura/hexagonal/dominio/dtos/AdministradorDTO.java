package br.unime.edu.arquitetura.hexagonal.dominio.dtos;

public class AdministradorDTO {
    private Integer pin;

    public AdministradorDTO() {
        super();
    }

    public AdministradorDTO(Integer pin) {
        this.pin = pin;
    }

    public Integer getPin() {
        return pin;
    }

}
