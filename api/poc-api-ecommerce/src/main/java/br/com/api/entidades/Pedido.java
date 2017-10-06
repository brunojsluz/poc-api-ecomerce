package br.com.api.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codigo")
	@SequenceGenerator(name= "pedido_codigo_seq", sequenceName = "pedido_codigo_seq", initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido_codigo_seq")
	private Integer codigo;
	
	@Column(name = "cliente")
	private String cliente;
	
	@Column(name = "data")
	private Date dataPedido;
	
	@Column(name = "telefone")
	private String telefone;
	
	@Column(name = "valor_total")
	private BigDecimal valorTotalPedido;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private StatusPedidoEnum status;
	
	@OneToMany(mappedBy="pedido")
	private List<ItemPedido> itensPedido;

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

	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}

}
