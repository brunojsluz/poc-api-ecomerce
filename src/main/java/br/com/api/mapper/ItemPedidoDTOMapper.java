package br.com.api.mapper;

import br.com.api.dto.ItemDTO;
import br.com.api.dto.ItemPedidoDTO;
import br.com.api.entidades.Item;
import br.com.api.entidades.ItemPedido;

public class ItemPedidoDTOMapper extends AbstractMapper<ItemPedido, ItemPedidoDTO> {

	@Override
	public ItemPedidoDTO converterDe(ItemPedido de) {
		if(de == null) {
			return null;
		}
		
		ItemPedidoDTO para  = new ItemPedidoDTO();
		para.setCodigo(de.getCodigo());
		para.setItem(converterItem(de.getItem()));
		para.setQuantidade(de.getQuantidade());
		para.setValor(de.getValor());
		para.setValorTotal(de.getValorTotal());
		return para;
	}

	private ItemDTO converterItem(Item item) {
		return new ItemDTOMapper().converterDe(item);
	}

}
