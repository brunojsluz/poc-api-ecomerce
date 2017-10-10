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
		
		PedidoDTO para = new PedidoDTO();
		para.setCliente(de.getCliente());
		para.setCodigo(de.getCodigo());
		para.setDataPedido(de.getDataPedido());
		para.setItensPedido(converterItemPedido(de.getItensPedido()));
		para.setStatus(de.getStatus());
		para.setTelefone(de.getTelefone());
		para.setValorTotalPedido(de.getValorTotalPedido());
		
		return para;
	}

	private List<ItemPedidoDTO> converterItemPedido(List<ItemPedido> itensPedido) {
		return new ItemPedidoDTOMapper().converterDe(itensPedido);
	}

}
