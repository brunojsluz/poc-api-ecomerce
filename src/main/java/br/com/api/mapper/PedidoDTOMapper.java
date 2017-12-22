package br.com.api.mapper;

import java.util.List;

import br.com.api.dto.ItemPedidoDTO;
import br.com.api.dto.PedidoDTO;
import br.com.api.entidades.ItemPedido;
import br.com.api.entidades.Pedido;

public class PedidoDTOMapper extends AbstractMapper<Pedido, PedidoDTO>{

	@Override
	public PedidoDTO converterDe(Pedido de) {
		if(de == null) {
			return null;
		}
		
		return PedidoDTO.builder()
		.cliente(de.getCliente())
		.codigo(de.getCodigo())
		.dataPedido(de.getDataPedido())
		.itensPedido(converterItemPedido(de.getItensPedido()))
		.status(de.getStatus())
		.telefone(de.getTelefone())
		.valorTotalPedido(de.getValorTotalPedido())
		.build();
		
	}

	private List<ItemPedidoDTO> converterItemPedido(List<ItemPedido> itensPedido) {
		return new ItemPedidoDTOMapper().converterDe(itensPedido);
	}

}
