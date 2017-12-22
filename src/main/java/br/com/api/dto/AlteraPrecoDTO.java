package br.com.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlteraPrecoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "O codigo do item é obrigatório")
	private Integer codigoItem;

	@NotNull(message = "O valor do item é obrigatório")
	@NumberFormat(pattern = "#.###,##")
	private BigDecimal valor;


}
