package br.com.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ItemPedidoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer codigo;
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
