package br.com.api.mapper;

import br.com.api.dto.ItemDTO;
import br.com.api.entidades.Item;

public class ItemDTOMapper extends AbstractMapper<Item, ItemDTO> {

	@Override
	public ItemDTO converterDe(Item de) {
		if(de == null) {
			return null;
		}

		return ItemDTO.builder()
		.codigo(de.getCodigo())
		.descricao(de.getDescricao())
		.observacao(de.getObservacao())
		.valor(de.getValor())
		.build();
	}

}
