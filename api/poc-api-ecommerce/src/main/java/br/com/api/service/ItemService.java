package br.com.api.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.dao.ItemRepository;
import br.com.api.dto.AlteraPrecoDTO;
import br.com.api.dto.ItemDTO;
import br.com.api.entidades.Item;
import br.com.api.mapper.ItemDTOMapper;
import br.com.api.mapper.ItemMapper;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository dao;

	public List<ItemDTO> listarItem() {
		Iterable<Item> iterable = dao.findAll();

		List<Item> itens = new ArrayList<Item>();
		
		CollectionUtils.addAll(itens, iterable);
												
		return new ItemDTOMapper().converterDe(itens);
	}
	
	public ItemDTO buscarItem(Integer codigo) {
		Item item = dao.findByCodigo(codigo);
		return new ItemDTOMapper().converterDe(item);
	}
	
	public void alteraPrecoItem(AlteraPrecoDTO alteraPreco) {
		Item item = dao.findByCodigo(alteraPreco.getCodigoItem());
		
		item.setValor(alteraPreco.getPreco());
	}
	
	public void alteraItem(ItemDTO itemDTO) {
		
	}
	
	public void salvarItem(ItemDTO itemDTO) {
		Item item = new ItemMapper().converterDe(itemDTO);
		dao.save(item);
	}

}
