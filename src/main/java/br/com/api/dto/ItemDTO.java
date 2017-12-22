package br.com.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer codigo;

	@NotNull(message = "A descrição do item é obrigatória")
	private String descricao;

	@NotNull(message = "O valor do item é obrigatório")
	private BigDecimal valor;

	@NotNull(message = "A observação do item é obrigatório")
	private String observacao;

}
