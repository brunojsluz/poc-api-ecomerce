package br.com.api.service;

import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import br.com.api.dao.PedidoRepository;
import br.com.api.dto.PedidoDTO;
import br.com.api.entidades.Pedido;
import br.com.api.entidades.StatusPedidoEnum;
import br.com.api.mapper.PedidoDTOMapper;
import br.com.api.utils.TestUtils;

public class PedidoServiceTest {
	
	@InjectMocks
	private PedidoService service;
	
	@Mock
	private PedidoRepository dao;

	@Captor
	private ArgumentCaptor<Pedido> pedidoCapture;
	
	@Before
	public void init() {
		initMocks(this);
	}
	
	@Test
	public void deveListarPedidos() {
		List<Pedido> listaPedidos = montaListaPedidos();

		Mockito.when(dao.findAll()).thenReturn(listaPedidos);
		
		List<PedidoDTO> listaPedidosDTO = service.listarPedidos();
		
		Assert.assertTrue(CollectionUtils.isNotEmpty(listaPedidosDTO));
		Assert.assertEquals(listaPedidosDTO.size(), 2);
	}
	
	@Test
	public void deveBuscarPedido() {
		Integer codigo = TestUtils.getRandomInteger();
		
		Pedido pedido = montaPedido();
		Mockito.when(dao.findByCodigo(codigo)).thenReturn(pedido);
		
		PedidoDTO pedidoDTO = service.buscarPedido(codigo);
		
		Assert.assertEquals(pedidoDTO.getCliente(), pedido.getCliente());
		Assert.assertEquals(pedidoDTO.getTelefone(), pedido.getTelefone());
		Assert.assertEquals(pedidoDTO.getCodigo(), pedido.getCodigo());
		Assert.assertEquals(pedidoDTO.getDataPedido(), pedido.getDataPedido());
		Assert.assertEquals(pedidoDTO.getStatus(), pedido.getStatus());
		Assert.assertEquals(pedidoDTO.getValorTotalPedido(), pedido.getValorTotalPedido());
	}
	
	@Test
	public void deveFecharOPedidoCasoOPedidoSejaEncontrado() {
		Integer codigo = TestUtils.getRandomInteger();
		
		Pedido pedido = montaPedido();
		Mockito.when(dao.findByCodigo(codigo)).thenReturn(pedido);
		
		service.fecharPedido(codigo );
		
		Mockito.verify(dao).save(pedidoCapture.capture());
		
		Assert.assertEquals(pedidoCapture.getValue().getStatus(), StatusPedidoEnum.FECHADO);
	}
	
	@Test
	public void naoDeveFecharOPedidoCasoOPedidoNaoSejaEncontrado() {
		Integer codigo = TestUtils.getRandomInteger();
		
		Pedido pedido = null;
		Mockito.when(dao.findByCodigo(codigo)).thenReturn(pedido);
		
		service.fecharPedido(codigo );
		
		Mockito.verify(dao, Mockito.never()).save(pedidoCapture.capture());
	}
	
	@Test
	public void deveAtualizarOuSalvarPedido() {
		PedidoDTO pedidoDTO = new PedidoDTOMapper().converterDe(montaPedido());
		service.atualizarPedido(pedidoDTO);
		
		Mockito.verify(dao).save(pedidoCapture.capture());
	}
	
	@Test
	public void deveExcluirPedido() {
		PedidoDTO pedidoDTO = new PedidoDTOMapper().converterDe(montaPedido());
		service.excluirPedido(pedidoDTO);
		
		Mockito.verify(dao).delete(pedidoCapture.capture());
	}

	private List<Pedido> montaListaPedidos() {
		return Arrays.asList(montaPedido(), montaPedido());
	}
	
	private Pedido montaPedido() {
		Pedido pedido = new Pedido();
		pedido.setCodigo(TestUtils.getRandomInteger());
		pedido.setCliente(TestUtils.getRandomString());
		pedido.setDataPedido(new Date());
		pedido.setStatus(StatusPedidoEnum.ABERTO);
		pedido.setTelefone(TestUtils.getRandomString());
		pedido.setValorTotalPedido(TestUtils.getRandomBigDecimal());
		return pedido;
	}

}
