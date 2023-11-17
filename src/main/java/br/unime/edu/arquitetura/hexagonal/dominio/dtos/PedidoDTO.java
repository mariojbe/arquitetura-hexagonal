package br.unime.edu.arquitetura.hexagonal.dominio.dtos;

import br.unime.edu.arquitetura.hexagonal.dominio.Cliente;
import br.unime.edu.arquitetura.hexagonal.dominio.Produto;

import java.util.Date;
import java.util.List;

public class PedidoDTO {
    private Cliente cliente;
    private List<Produto> produtos;
    private Date dataDoPedido;
    private Integer quantidadeDeProdutos;
    private String tipoDePagamento;
    private Double valorDoPedido;

    public PedidoDTO() {
        super();
    }

    public PedidoDTO(Cliente cliente, List<Produto> produtos, Date dataDoPedido, Integer quantidadeDeProdutos, String tipoDePagamento, Double valorDoPedido) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.dataDoPedido = dataDoPedido;
        this.quantidadeDeProdutos = quantidadeDeProdutos;
        this.tipoDePagamento = tipoDePagamento;
        this.valorDoPedido = valorDoPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Date getDataDoPedido() {
        return dataDoPedido;
    }

    public Integer getQuantidadeDeProdutos() {
        return quantidadeDeProdutos;
    }

    public String getTipoDePagamento() {
        return tipoDePagamento;
    }

    public Double getValorDoPedido() {
        return valorDoPedido;
    }


}
