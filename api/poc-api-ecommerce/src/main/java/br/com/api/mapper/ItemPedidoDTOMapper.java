package br.com.api.mapper;

import br.com.api.dto.ItemDTO;
import br.com.api.dto.ItemPedidoDTO;
import br.com.api.dto.PedidoDTO;
import br.com.api.entidades.Item;
import br.com.api.entidades.ItemPedido;
import br.com.api.entidades.Pedido;

public class ItemPedidoDTOMapper extends AbstractMapper<ItemPedido, ItemPedidoDTO> {

	@Override
	public ItemPedidoDTO converterDe(ItemPedido de) {
		if(de == null) {
			return null;
		}
		
		ItemPedidoDTO para  = new ItemPedidoDTO();
		para.setCodigo(de.getCodigo());
		para.setItem(converterItem(de.getItem()));
		para.setPedidoDTO(converterPedido(de.getPedido()));
		para.setQuantidade(de.getQuantidade());
		para.setValor(de.getValor());
		para.setValorTotal(de.getValorTotal());
		return para;
	}

	private PedidoDTO converterPedido(Pedido pedido) {
		return new PedidoDTOMapper().converterDe(pedido);
	}

	private ItemDTO converterItem(Item item) {
		return new ItemDTOMapper().converterDe(item);
	}

}
