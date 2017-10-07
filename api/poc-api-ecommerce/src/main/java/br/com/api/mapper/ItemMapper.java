package br.com.api.mapper;

import br.com.api.dto.ItemDTO;
import br.com.api.entidades.Item;

public class ItemMapper extends AbstractMapper<ItemDTO, Item> {

	@Override
	public Item converterDe(ItemDTO de) {
		Item para = new Item();
		para.setCodigo(de.getCodigo());
		para.setDescricao(de.getDescricao());
		para.setObservacao(de.getObservacao());
		para.setValor(de.getValor());
		return para;
	}

}
