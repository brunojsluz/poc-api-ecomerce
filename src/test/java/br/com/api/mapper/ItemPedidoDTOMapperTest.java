package br.com.api.mapper;

import org.junit.Assert;
import org.junit.Test;

import br.com.api.dto.ItemPedidoDTO;
import br.com.api.entidades.ItemPedido;
import br.com.api.utils.TestUtils;

public class ItemPedidoDTOMapperTest {
	
	@Test
	public void deveConverterDeItemPedidoParaItemPedidoDTO() {
		ItemPedido itemPedido = montarItemPedido();
		ItemPedidoDTO itemPedidoDTO = new ItemPedidoDTOMapper().converterDe(itemPedido);
		
		Assert.assertEquals(itemPedidoDTO.getCodigo(), itemPedido.getCodigo());
		Assert.assertEquals(itemPedidoDTO.getQuantidade(), itemPedido.getQuantidade());
		Assert.assertEquals(itemPedidoDTO.getValor(), itemPedido.getValor());
		Assert.assertEquals(itemPedidoDTO.getValorTotal(), itemPedido.getValorTotal());
	}

	@Test
	public void naoDeveConverterDeItemPedidoParaItemPedidoDTOQuandoItemPedidoForNulo() {
		ItemPedido de = null;
		ItemPedidoDTO itemPedidoDTO = new ItemPedidoDTOMapper().converterDe(de);
		
		Assert.assertNull(itemPedidoDTO);
	}
	
	public ItemPedido montarItemPedido() {
		ItemPedido item = new ItemPedido();
		item.setCodigo(TestUtils.getRandomInteger());
		item.setQuantidade(TestUtils.getRandomInteger());
		item.setValor(TestUtils.getRandomBigDecimal());
		item.setValorTotal(TestUtils.getRandomBigDecimal());
		return item;
	}

}
