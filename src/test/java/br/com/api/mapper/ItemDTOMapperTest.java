
package br.com.api.mapper;

import org.junit.Assert;
import org.junit.Test;

import br.com.api.dto.ItemDTO;
import br.com.api.entidades.Item;
import br.com.api.utils.TestUtils;

public class ItemDTOMapperTest {
	
	@Test
	public void deveConverterDeItemParaItemDTO() {
		Item item = montaItem();
		ItemDTO itemDTO = new ItemDTOMapper().converterDe(item);
		
		Assert.assertEquals(itemDTO.getDescricao(), item.getDescricao());
		Assert.assertEquals(itemDTO.getObservacao(), item.getObservacao());
		Assert.assertEquals(itemDTO.getCodigo(), item.getCodigo());
		Assert.assertEquals(itemDTO.getValor(), item.getValor());
		
	}
	
	@Test
	public void naoDeveConverterDeItemParaItemDTOQuandoItemForNulo() {
		Item item = null;
		ItemDTO itemDTO = new ItemDTOMapper().converterDe(item);
		
		Assert.assertNull(itemDTO);
	}
	
	private Item montaItem() {
		Item item = new Item();
		item.setCodigo(TestUtils.getRandomInteger());
		item.setDescricao(TestUtils.getRandomString());
		item.setObservacao(TestUtils.getRandomString());
		item.setValor(TestUtils.getRandomBigDecimal());
		return item;
	}

}
