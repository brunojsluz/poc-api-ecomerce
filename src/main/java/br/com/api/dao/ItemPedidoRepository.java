package br.com.api.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.api.entidades.ItemPedido;

public interface ItemPedidoRepository  extends PagingAndSortingRepository<ItemPedido, Long> {
	

}
