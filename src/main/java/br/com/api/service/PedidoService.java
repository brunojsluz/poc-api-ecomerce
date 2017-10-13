package br.com.api.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.dao.PedidoRepository;
import br.com.api.dto.PedidoDTO;
import br.com.api.entidades.Pedido;
import br.com.api.entidades.StatusPedidoEnum;
import br.com.api.mapper.PedidoDTOMapper;
import br.com.api.mapper.PedidoMapper;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoDao;
	
	public List<PedidoDTO> listarPedidos() {
		Iterable<Pedido> pedidosIterable = pedidoDao.findAll();
		
		List<Pedido> pedidos = new ArrayList<>();
		
		if(pedidosIterable != null) {
			CollectionUtils.addAll(pedidos, pedidosIterable);
		}
		
		return new PedidoDTOMapper().converterDe(pedidos);
	}
	
	public PedidoDTO buscarPedido(Integer codigo) {
		Pedido pedido = pedidoDao.findByCodigo(codigo);
		return new PedidoDTOMapper().converterDe(pedido);
	}
	
	public void fecharPedido(Integer codigo) {
		Pedido pedido = pedidoDao.findByCodigo(codigo);
		
		if(pedido != null) {
			pedido.setStatus(StatusPedidoEnum.FECHADO);
			pedidoDao.save(pedido);
		}
	}
	
	public void atualizarPedido(PedidoDTO pedidoDTO) {
		salvarPedido(pedidoDTO);
	}

	public void salvarPedido(PedidoDTO pedidoDTO) {
		Pedido pedido = new PedidoMapper().converterDe(pedidoDTO);
		pedidoDao.save(pedido);
	}
	
	public void excluirPedido(PedidoDTO pedidoDTO) {
		Pedido pedido = new PedidoMapper().converterDe(pedidoDTO);
		pedidoDao.delete(pedido);
	}

}
