package br.com.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer codigo;
	private ItemDTO item;
	private BigDecimal valor;
	private Integer quantidade;
	private BigDecimal valorTotal;

}
