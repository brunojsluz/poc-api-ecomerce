package br.com.api.mapper;

import org.junit.Assert;
import org.junit.Test;

import br.com.api.dto.ItemDTO;
import br.com.api.entidades.Item;
import br.com.api.utils.TestUtils;

public class ItemMapperTest {
	
	@Test
	public void deveConverterDeItemDTOParaItem() {
		ItemDTO itemDTO = montaItemDTO();
		Item item = new ItemMapper().converterDe(itemDTO);
		
		Assert.assertEquals(item.getDescricao(), itemDTO.getDescricao());
		Assert.assertEquals(item.getObservacao(), itemDTO.getObservacao());
		Assert.assertEquals(item.getCodigo(), itemDTO.getCodigo());
		Assert.assertEquals(item.getValor(), itemDTO.getValor());
	}

	@Test
	public void naoDeveConverterDeItemDTOParaItemQuandoItemDorNulo() {
		ItemDTO itemDTO = null;
		Item item = new ItemMapper().converterDe(itemDTO);
		
		Assert.assertNull(item);
	}

	private ItemDTO montaItemDTO() {
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setCodigo(TestUtils.getRandomInteger());
		itemDTO.setDescricao(TestUtils.getRandomString());
		itemDTO.setObservacao(TestUtils.getRandomString());
		itemDTO.setValor(TestUtils.getRandomBigDecimal());
		return itemDTO;
	}
}
