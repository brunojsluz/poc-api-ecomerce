package br.com.api.mapper;

import br.com.api.dto.ItemDTO;
import br.com.api.dto.ItemPedidoDTO;
import br.com.api.dto.PedidoDTO;
import br.com.api.entidades.Item;
import br.com.api.entidades.ItemPedido;
import br.com.api.entidades.Pedido;

public class ItemPedidoMapper extends AbstractMapper<ItemPedidoDTO, ItemPedido>{

	@Override
	public ItemPedido converterDe(ItemPedidoDTO de) {
		if(de == null) {
			return null;
		}
		
		ItemPedido para  = new ItemPedido();
		para.setCodigo(de.getCodigo());
		para.setItem(converterItem(de.getItem()));
		para.setPedido(converterPedido(de.getPedidoDTO()));
		para.setQuantidade(de.getQuantidade());
		para.setValor(de.getValor());
		para.setValorTotal(de.getValorTotal());
		return para;
	}

	private Pedido converterPedido(PedidoDTO pedidoDTO) {
		return new PedidoMapper().converterDe(pedidoDTO);
	}

	private Item converterItem(ItemDTO item) {
		return new ItemMapper().converterDe(item);
	}

}
