package br.com.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.math.BigDecimal;

public class ItemDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer codigo;

	@NotNull(message = "A descrição do item é obrigatória")
	private String descricao;

	@NotNull(message = "O valor do item é obrigatório")
	private BigDecimal valor;

	@NotNull(message = "A observação do item é obrigatório")
	private String observacao;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
