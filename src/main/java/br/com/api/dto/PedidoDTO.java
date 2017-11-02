package br.com.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.api.entidades.StatusPedidoEnum;

import javax.validation.constraints.NotNull;

public class PedidoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer codigo;

	@NotNull(message = "O cliente é obrigatório")
	private String cliente;

	@NotNull(message = "A data do pedido é obrigatória")
	private Date dataPedido;

	@NotNull(message = "O telefone é obrigatório")
	private String telefone;

	@NotNull(message = "O valor total do pedido é obrigatório")
	private BigDecimal valorTotalPedido;

	@NotNull(message = "O status do pedido é obrigatório")
	private StatusPedidoEnum status;

	@NotNull(message = "A liste de itens do pedido é obrigatória")
	private List<ItemPedidoDTO> itensPedido;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public BigDecimal getValorTotalPedido() {
		return valorTotalPedido;
	}

	public void setValorTotalPedido(BigDecimal valorTotalPedido) {
		this.valorTotalPedido = valorTotalPedido;
	}

	public StatusPedidoEnum getStatus() {
		return status;
	}

	public void setStatus(StatusPedidoEnum status) {
		this.status = status;
	}

	public List<ItemPedidoDTO> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItemPedidoDTO> itensPedido) {
		this.itensPedido = itensPedido;
	}

}
