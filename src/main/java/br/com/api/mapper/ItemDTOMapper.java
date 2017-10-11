package br.com.api.mapper;

import br.com.api.dto.ItemDTO;
import br.com.api.entidades.Item;

public class ItemDTOMapper extends AbstractMapper<Item, ItemDTO> {

	@Override
	public ItemDTO converterDe(Item de) {
		if(de == null) {
			return null;
		}
		
		ItemDTO para = new ItemDTO();
		para.setCodigo(de.getCodigo());
		para.setDescricao(de.getDescricao());
		para.setObservacao(de.getObservacao());
		para.setValor(de.getValor());
		return para;
	}

}
