package br.unime.edu.arquitetura.hexagonal.infraestrutura.adaptadores.entidades;

import br.unime.edu.arquitetura.hexagonal.dominio.Cliente;
import br.unime.edu.arquitetura.hexagonal.dominio.Pedido;
import br.unime.edu.arquitetura.hexagonal.dominio.Produto;
import com.sun.istack.NotNull;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @ManyToOne// ManyToOne indicando que um pedido pertence a um único cliente
    @JoinColumn(name = "cliente_id")
    @NotNull
    private Cliente cliente;
    @ManyToMany
    // ManyToMany entre Pedido e Produto, permitindo que um pedido possa conter vários produtos e um produto possa estar em vários pedidos.
    @JoinTable(name = "pedido_produtos",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id"))// pedido_produtos tabela
    @NotNull
    private List<Produto> produtos;

    @NotNull
    private Date dataDoPedido;

    @NotNull
    private Integer quantidadeDeProdutos;

    @NotNull
    private String tipoDePagamento;

    @NotNull
    private Double valorDoPedido;

    public PedidoEntity() {
    }

    public PedidoEntity(Pedido pedido) {
        this.cliente = pedido.getCliente();
        this.produtos = pedido.getProdutos();
        this.dataDoPedido = pedido.getDataDoPedido();
        this.quantidadeDeProdutos = pedido.getQuantidadeDeProdutos();
        this.tipoDePagamento = pedido.getTipoDePagamento();
        this.valorDoPedido = pedido.getValorDoPedido();
    }

    public void atualizar(Pedido pedido) {
        this.cliente = pedido.getCliente();
        this.produtos = pedido.getProdutos();
        this.dataDoPedido = pedido.getDataDoPedido();
        this.quantidadeDeProdutos = pedido.getQuantidadeDeProdutos();
        this.tipoDePagamento = pedido.getTipoDePagamento();
        this.valorDoPedido = pedido.getValorDoPedido();
    }

    public Pedido toPedido() {
        return new Pedido(this.id, this.cliente, this.produtos, this.dataDoPedido, this.quantidadeDeProdutos, this.tipoDePagamento, this.valorDoPedido);
    }
}
