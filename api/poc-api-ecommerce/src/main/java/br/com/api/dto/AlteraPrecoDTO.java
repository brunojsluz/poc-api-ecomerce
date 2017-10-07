package br.com.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class AlteraPrecoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer codigoItem;
	private BigDecimal preco;

	public Integer getCodigoItem() {
		return codigoItem;
	}

	public void setCodigoItem(Integer codigoItem) {
		this.codigoItem = codigoItem;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
