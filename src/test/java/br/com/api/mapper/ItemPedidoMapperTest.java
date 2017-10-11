package br.com.api.mapper;

import org.junit.Assert;
import org.junit.Test;

import br.com.api.dto.ItemPedidoDTO;
import br.com.api.entidades.ItemPedido;
import br.com.api.utils.TestUtils;

public class ItemPedidoMapperTest {
	
	@Test
	public void deveConverterItemPedidoDTOParaItemPedido() {
		
		ItemPedidoDTO itemPedidoDTO = montarItemPedidoDTO();
		ItemPedido itemPedido = new ItemPedidoMapper().converterDe(itemPedidoDTO);
		
		Assert.assertEquals(itemPedido.getCodigo(), itemPedidoDTO.getCodigo());
		Assert.assertEquals(itemPedido.getQuantidade(), itemPedidoDTO.getQuantidade());
		Assert.assertEquals(itemPedido.getValor(), itemPedidoDTO.getValor());
		Assert.assertEquals(itemPedido.getValorTotal(), itemPedidoDTO.getValorTotal());
	}

	@Test
	public void naoDeveConverterItemPedidoDTOParaItemPedidoQuandoItemPedidoDTOForNulo() {
		
		ItemPedidoDTO de = null;
		ItemPedido itemPedido = new ItemPedidoMapper().converterDe(de);
		
		Assert.assertNull(itemPedido);
	}
	
	public ItemPedidoDTO montarItemPedidoDTO() {
		ItemPedidoDTO item = new ItemPedidoDTO();
		item.setCodigo(TestUtils.getRandomInteger());
		item.setQuantidade(TestUtils.getRandomInteger());
		item.setValor(TestUtils.getRandomBigDecimal());
		item.setValorTotal(TestUtils.getRandomBigDecimal());
		return item;
	}

}
