package br.com.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.api.entidades.Pedido;

public class ItemPedidoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer codigo;
	private Pedido pedido;
	private ItemDTO item;
	private BigDecimal valor;
	private Integer quantidade;
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

	public ItemDTO getItem() {
		return item;
	}

	public void setItem(ItemDTO item) {
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
