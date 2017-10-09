package br.com.api.dao;


import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.api.entidades.Item;

public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {
	
	public Item findByCodigo(@Param("codigo") Integer codigo);
	
	public List<Item> findByDescricaoContainingIgnoreCase(@Param("descricao") String descricao);

}
