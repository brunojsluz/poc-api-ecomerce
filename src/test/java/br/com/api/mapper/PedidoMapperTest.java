package br.com.api.mapper;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.com.api.dto.PedidoDTO;
import br.com.api.entidades.Pedido;
import br.com.api.entidades.StatusPedidoEnum;
import br.com.api.utils.TestUtils;

public class PedidoMapperTest {
	
	@Test
	public void deveConverterDePedidoDTOParaPedido() {
		PedidoDTO de = montaPedidoDTO();
		Pedido pedido = new PedidoMapper().converterDe(de);
		
		Assert.assertEquals(pedido.getCliente(), de.getCliente());
		Assert.assertEquals(pedido.getTelefone(), de.getTelefone());
		Assert.assertEquals(pedido.getCodigo(), de.getCodigo());
		Assert.assertEquals(pedido.getDataPedido(), de.getDataPedido());
		Assert.assertEquals(pedido.getStatus(), de.getStatus());
		Assert.assertEquals(pedido.getValorTotalPedido(), de.getValorTotalPedido());
	}

	@Test
	public void naoDeveConverterDePedidoDTOParaPedidoQuandoPedidoDTOForNulo() {
		PedidoDTO de = null;
		Pedido pedido = new PedidoMapper().converterDe(de);
		
		Assert.assertNull(pedido);
	}
	
	private PedidoDTO montaPedidoDTO() {
		PedidoDTO pedido = new PedidoDTO();
		pedido.setCliente(TestUtils.getRandomString());
		pedido.setCodigo(TestUtils.getRandomInteger());
		pedido.setDataPedido(new Date());
		pedido.setStatus(StatusPedidoEnum.FECHADO);
		pedido.setTelefone(TestUtils.getRandomString());
		pedido.setValorTotalPedido(TestUtils.getRandomBigDecimal());
		return pedido;
	}

}
