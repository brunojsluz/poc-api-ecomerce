package br.com.api.mapper;

import br.com.api.dto.ItemDTO;
import br.com.api.dto.ItemPedidoDTO;
import br.com.api.entidades.Item;
import br.com.api.entidades.ItemPedido;

public class ItemPedidoMapper extends AbstractMapper<ItemPedidoDTO, ItemPedido>{

	@Override
	public ItemPedido converterDe(ItemPedidoDTO de) {
		if(de == null) {
			return null;
		}
		
		ItemPedido para  = new ItemPedido();
		para.setCodigo(de.getCodigo());
		para.setItem(converterItem(de.getItem()));
		para.setQuantidade(de.getQuantidade());
		para.setValor(de.getValor());
		para.setValorTotal(de.getValorTotal());
		return para;
	}

	private Item converterItem(ItemDTO item) {
		return new ItemMapper().converterDe(item);
	}

}
