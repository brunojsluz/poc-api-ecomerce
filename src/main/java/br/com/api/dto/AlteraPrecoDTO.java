package br.com.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;

public class AlteraPrecoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "O codigo do item é obrigatório")
	private Integer codigoItem;

	@NotNull(message = "O valor do item é obrigatório")
	@NumberFormat(pattern = "#.###,##")
	private BigDecimal valor;

	public Integer getCodigoItem() {
		return codigoItem;
	}

	public void setCodigoItem(Integer codigoItem) {
		this.codigoItem = codigoItem;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
