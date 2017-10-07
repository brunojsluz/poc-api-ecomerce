package br.com.api.teste;

import java.math.BigDecimal;

import br.com.api.entidades.Item;
import br.com.api.entidades.ItemPedido;

public class TestandoEntidades {

//	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("poc-api");
//	
//	public void buscarEntidades() {
//		EntityManager entity = emf.createEntityManager();
//		
//		Pedido pedido = entity.find(Pedido.class, 102);
//		
//		System.out.println(pedido.getStatus());
//		
//	}
//	
//	public void inserirEntidades() {
//		
//		EntityManager entity = emf.createEntityManager();
//		
//		Item item = new Item();
//		item.setDescricao("Desodorante");
//		item.setValor(BigDecimal.TEN);
//		item.setObservacao("Desodorante spray");
//		
//		
//		Pedido pedido = new Pedido();
//		pedido.setCliente("Bruno Luz");
//		pedido.setDataPedido(new Date());
//		pedido.setStatus(StatusPedidoEnum.ABERTO);
//		pedido.setTelefone("51981911387");
//		pedido.setValorTotalPedido(BigDecimal.TEN);
//		
//		ItemPedido itemPedido = new ItemPedido();
//		itemPedido.setItem(item);
//		itemPedido.setQuantidade(1);
//		itemPedido.setValor(BigDecimal.ONE);
//		itemPedido.setValorTotal(BigDecimal.TEN);
//		itemPedido.setPedido(pedido);
//		
//		
//		pedido.setItensPedido(Arrays.asList(criarItensPedido()));
//		
//		entity.getTransaction().begin();
//		entity.persist(item);
//		entity.persist(pedido);
//		entity.persist(itemPedido);
//		entity.getTransaction().commit();
//		
//		
//		entity.close();
//	}
//	
	private ItemPedido criarItensPedido() {
		Item item = new Item();
		item.setDescricao("Desodorante");
		item.setValor(BigDecimal.TEN);
		item.setObservacao("Desodorante spray");
		
		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setItem(item);
		itemPedido.setQuantidade(1);
		itemPedido.setValor(BigDecimal.ONE);
		itemPedido.setValorTotal(BigDecimal.TEN);
		return itemPedido;
	}

	public static void main(String[] args) {
		new TestandoEntidades().criarItensPedido();
	}

}
