package br.unime.edu.arquitetura.hexagonal.dominio;

import br.unime.edu.arquitetura.hexagonal.dominio.dtos.PedidoDTO;

import java.util.Date;
import java.util.List;

public class Pedido {

    private Long id;
    private Cliente cliente;
    private List<Produto> produtos;
    private Date dataDoPedido;
    private Integer quantidadeDeProdutos;
    private String tipoDePagamento;
    private Double valorDoPedido;

    public Pedido() {
    }

    public Pedido(Long id, Cliente cliente, List<Produto> produtos, Date dataDoPedido, Integer quantidadeDeProdutos, String tipoDePagamento, Double valorDoPedido) {
        this.id = id;
        this.cliente = cliente;
        this.produtos = produtos;
        this.dataDoPedido = dataDoPedido;
        this.quantidadeDeProdutos = quantidadeDeProdutos;
        this.tipoDePagamento = tipoDePagamento;
        this.valorDoPedido = valorDoPedido;
    }

    public Long getId() {
        return id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Cliente getCliente() {
        return cliente;
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


    public Pedido(PedidoDTO pedidoDTO) {
        this.cliente = pedidoDTO.getCliente();
        this.produtos = pedidoDTO.getProdutos();
        this.dataDoPedido = pedidoDTO.getDataDoPedido();
        this.quantidadeDeProdutos = pedidoDTO.getQuantidadeDeProdutos();
        this.tipoDePagamento = pedidoDTO.getTipoDePagamento();
        this.valorDoPedido = pedidoDTO.getValorDoPedido();
    }

    /*public void atualizarEstoque(double quantidade) {
        this.quantidade = quantidade;
    }*/

    public PedidoDTO toPedidoDTO() {
        return new PedidoDTO(this.cliente, this.produtos, this.dataDoPedido, this.quantidadeDeProdutos, this.tipoDePagamento, this.valorDoPedido);
    }

}
