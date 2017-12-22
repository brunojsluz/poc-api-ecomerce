package br.com.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import br.com.api.exception.ErroInternoException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
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

	@Deprecated
	public List<ItemDTO> listarItem() {
		Iterable<Item> itensIterable = dao.findAll();

		List<Item> itens = new ArrayList<Item>();

		if(itensIterable != null) {
			CollectionUtils.addAll(itens, itensIterable);
		}

		return new ItemDTOMapper().converterDe(itens);
	}

	public List<ItemDTO> listarItemV2() {
		List<ItemDTO> itens = new ArrayList<>();

		dao.findAll().forEach(item -> itens.add(new ItemDTOMapper().converterDe(item)));

		return itens;
	}

	public ItemDTO buscarItem(Integer codigo) {
		Item item = dao.findByCodigo(codigo);
		return new ItemDTOMapper().converterDe(item);
	}

	@Deprecated
	public Boolean alteraPrecoItem(AlteraPrecoDTO alteraPreco) {
		Item item = dao.findByCodigo(alteraPreco.getCodigoItem());

		if(item != null) {
			item.setValor(alteraPreco.getValor());
			dao.save(item);
			return Boolean.TRUE;
		} else {
			throw new ErroInternoException("Não foi possivel alterar o valor do item.");
		}
	}

	public Boolean alteraPrecoItemV2(AlteraPrecoDTO alteraPreco) {
		return Optional.ofNullable(dao.findByCodigo(alteraPreco.getCodigoItem()))
				.map(item -> {
					item.setValor(alteraPreco.getValor());
					dao.save(item);
					return Boolean.TRUE;
				})
				.orElseThrow(() -> new ErroInternoException("Não foi possivel alterar o valor do item."));
	}

	public List<ItemDTO> buscarPorDescricao(String descricao) {
		if(StringUtils.isEmpty(descricao)) {
			return listarItemV2();
		}

		List<Item> listaItem = dao.findByDescricaoContainingIgnoreCase(descricao);
		return new ItemDTOMapper().converterDe(listaItem);
	}

	public void alteraItem(ItemDTO itemDTO) {
		salvarItem(itemDTO);
	}
	
	public void salvarItem(ItemDTO itemDTO) {
		Item item = new ItemMapper().converterDe(itemDTO);
		dao.save(item);
	}

	public void excluirItem(ItemDTO itemDTO) {
		Item item = new ItemMapper().converterDe(itemDTO);
		dao.delete(item);
	}

}
