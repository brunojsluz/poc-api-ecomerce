package br.com.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.api.entidades.StatusPedidoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

}
