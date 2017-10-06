package br.com.api.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="itens_pedido")
public class ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="")
	@SequenceGenerator(name="itens_pedido_codigo_seq", sequenceName="itens_pedido_codigo_seq", initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="itens_pedido_codigo_seq") 
	private Integer codigo;
	
	@ManyToOne
	@JoinColumn(name = "codigo_pedido", nullable = false)
	private Pedido pedido;
	
	@OneToOne
	@JoinColumn(name = "codigo_item", nullable = false)
	private Item item;
	
	@Column(name="valor")
	private BigDecimal valor;
	
	@Column(name="quantidade")
	private Integer quantidade;
	
	@Column(name="valor_total")
	private BigDecimal valorTotal;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

}
