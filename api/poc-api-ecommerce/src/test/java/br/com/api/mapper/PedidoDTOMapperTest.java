package br.com.api.mapper;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.com.api.dto.PedidoDTO;
import br.com.api.entidades.Pedido;
import br.com.api.entidades.StatusPedidoEnum;
import br.com.api.utils.TestUtils;

public class PedidoDTOMapperTest {
	
	@Test
	public void deveConverterDePedidoParaPedidoDTO() {
		Pedido de = montarPedido();
		PedidoDTO pedidoDTO = new PedidoDTOMapper().converterDe(de);
		
		Assert.assertEquals(pedidoDTO.getCliente(), de.getCliente());
		Assert.assertEquals(pedidoDTO.getTelefone(), de.getTelefone());
		Assert.assertEquals(pedidoDTO.getCodigo(), de.getCodigo());
		Assert.assertEquals(pedidoDTO.getDataPedido(), de.getDataPedido());
		Assert.assertEquals(pedidoDTO.getStatus(), de.getStatus());
		Assert.assertEquals(pedidoDTO.getValorTotalPedido(), de.getValorTotalPedido());
	}
	
	@Test
	public void naoDeveConverteDePedidoParaPedidoDTOQuandoPedidoForNullo() {
		Pedido de = null;
		PedidoDTO pedidoDTO = new PedidoDTOMapper().converterDe(de);
		
		Assert.assertNull(pedidoDTO);
	}

	private Pedido montarPedido() {
		Pedido pedido = new Pedido();
		pedido.setCliente(TestUtils.getRandomString());
		pedido.setCodigo(TestUtils.getRandomInteger());
		pedido.setDataPedido(new Date());
		pedido.setStatus(StatusPedidoEnum.FECHADO);
		pedido.setTelefone(TestUtils.getRandomString());
		pedido.setValorTotalPedido(TestUtils.getRandomBigDecimal());
		return pedido;
	}

}
