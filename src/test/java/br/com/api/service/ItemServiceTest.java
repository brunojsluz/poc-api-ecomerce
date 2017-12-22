package br.com.api.service;

import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.api.exception.ErroInternoException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import br.com.api.dao.ItemRepository;
import br.com.api.dto.AlteraPrecoDTO;
import br.com.api.dto.ItemDTO;
import br.com.api.entidades.Item;
import br.com.api.mapper.ItemDTOMapper;
import br.com.api.utils.TestUtils;

public class ItemServiceTest {

	@InjectMocks
	private ItemService service;

	@Mock
	private ItemRepository dao;
	
	@Captor
	private ArgumentCaptor<Item> itemCapture;

	@Before
	public void init() {
		initMocks(this);
	}

	@Test
	public void deveListarItens() {
		List<Item> listaItens = montaListaItem();

		Mockito.when(dao.findAll()).thenReturn(listaItens);

		List<ItemDTO> itens = service.listarItemV2();

		Assert.assertFalse(itens.isEmpty());
		Assert.assertEquals(itens.size(), 2);
	}

	@Test
	public void deveRetornarListaVaziaQuandoNaoHouverItensNoBanco() {
		List<Item> listaItens = new ArrayList<>();
		
		Mockito.when(dao.findAll()).thenReturn(listaItens);
		
		List<ItemDTO> itens = service.listarItemV2();
		
		Assert.assertTrue(itens.isEmpty());
	}
	
	@Test
	public void deveBuscarItem() {
		Integer codigo = TestUtils.getRandomInteger();
		
		Item item = montaItem();
		Mockito.when(dao.findByCodigo(codigo)).thenReturn(item);
		
		ItemDTO itemDTO = service.buscarItem(codigo);
		
		Assert.assertEquals(itemDTO.getCodigo(), item.getCodigo());
		Assert.assertEquals(itemDTO.getDescricao(), item.getDescricao());
		Assert.assertEquals(itemDTO.getObservacao(), item.getObservacao());
		Assert.assertEquals(itemDTO.getValor(), item.getValor());
	}
	
	@Test
	public void deveAlterarPrecoDoItemQuandoItemForEncontrado() {
		AlteraPrecoDTO alteraPreco = montaPrecoITem();
		
		Item item = montaItem();
		Mockito.when(dao.findByCodigo(alteraPreco.getCodigoItem())).thenReturn(item);
		
		service.alteraPrecoItemV2(alteraPreco);
		
		Mockito.verify(dao).save(itemCapture.capture());
		
		Assert.assertEquals(itemCapture.getValue().getValor(), alteraPreco.getValor());
	}
	

	public void naoDeveAlterarPrecoDoItemQuandoItemNaoForEncontrado() {
		AlteraPrecoDTO alteraPreco = montaPrecoITem();
		
		Item item = null;
		Mockito.when(dao.findByCodigo(alteraPreco.getCodigoItem())).thenReturn(item);
		
		service.alteraPrecoItemV2(alteraPreco);
		
		Mockito.verify(dao, Mockito.never()).save(itemCapture.capture());
	}
	
	@Test
	public void deveBuscarPorDescricao() {
		String descricao = TestUtils.getRandomString();
		
		Mockito.when(dao.findByDescricaoContainingIgnoreCase(descricao)).thenReturn(montaListaItem());
		
		List<ItemDTO> listaItens = service.buscarPorDescricao(descricao);
		
		Assert.assertFalse(listaItens.isEmpty());
	}
	
	@Test
	public void deveAlterarItem() {
		ItemDTO itemDTO = new ItemDTOMapper().converterDe(montaItem());
		service.alteraItem(itemDTO);
		
		Mockito.verify(dao).save(itemCapture.capture());
	}
	
	@Test
	public void deveSalvarItem() {
		ItemDTO itemDTO = new ItemDTOMapper().converterDe(montaItem());
		service.salvarItem(itemDTO);
		
		Mockito.verify(dao).save(itemCapture.capture());
	}
	@Test
	public void deveExcluirItem() {
		ItemDTO itemDTO = new ItemDTOMapper().converterDe(montaItem());
		service.excluirItem(itemDTO);
		
		Mockito.verify(dao).delete(itemCapture.capture());
	}

	private AlteraPrecoDTO montaPrecoITem() {
		AlteraPrecoDTO altera = new AlteraPrecoDTO();
		altera.setCodigoItem(TestUtils.getRandomInteger());
		altera.setValor(TestUtils.getRandomBigDecimal());
		return altera;
	}

	private List<Item> montaListaItem() {
		return Arrays.asList(montaItem(), montaItem());
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
