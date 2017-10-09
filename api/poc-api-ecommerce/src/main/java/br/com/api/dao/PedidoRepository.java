package br.com.api.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.api.entidades.Pedido;

public interface PedidoRepository extends PagingAndSortingRepository<Pedido, Long> {
	
	public Pedido findByCodigo(@Param("codigo") Integer codigo);

}
