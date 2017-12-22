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
		
		return ItemPedidoDTO.builder()
		.codigo(de.getCodigo())
		.item(converterItem(de.getItem()))
		.quantidade(de.getQuantidade())
		.valor(de.getValor())
		.valorTotal(de.getValorTotal())
		.build();
	}

	private ItemDTO converterItem(Item item) {
		return new ItemDTOMapper().converterDe(item);
	}

}
