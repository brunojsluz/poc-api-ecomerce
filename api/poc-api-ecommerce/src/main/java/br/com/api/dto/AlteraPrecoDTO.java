package br.com.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;

public class AlteraPrecoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer codigoItem;
	
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
