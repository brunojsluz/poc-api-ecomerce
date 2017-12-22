package br.com.api.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import br.com.api.exception.ErroInternoException;
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

	@Deprecated
	public List<PedidoDTO> listarPedidos() {
		Iterable<Pedido> pedidosIterable = pedidoDao.findAll();
		
		List<Pedido> pedidos = new ArrayList<>();
		
		if(pedidosIterable != null) {
			CollectionUtils.addAll(pedidos, pedidosIterable);
		}
		
		return new PedidoDTOMapper().converterDe(pedidos);
	}

	public List<PedidoDTO> listarPedidosV2() {
		List<PedidoDTO> pedidos = new ArrayList<>();

		pedidoDao.findAll().forEach(pedido -> pedidos.add(new PedidoDTOMapper().converterDe(pedido)));

		return pedidos;
	}
	
	public PedidoDTO buscarPedido(Integer codigo) {
		Pedido pedido = pedidoDao.findByCodigo(codigo);
		return new PedidoDTOMapper().converterDe(pedido);
	}

	@Deprecated
	public Boolean fecharPedido(Integer codigo) {
		Pedido pedido = pedidoDao.findByCodigo(codigo);
		
		if(pedido != null) {
			pedido.setStatus(StatusPedidoEnum.FECHADO);
			pedidoDao.save(pedido);
            return Boolean.TRUE;
		} else {
			throw new ErroInternoException("Pedido não encontrado.");
		}
	}

	public Boolean fecharPedidoV2(Integer codigo) {
		return Optional.ofNullable(pedidoDao.findByCodigo(codigo))
                .map(pedido -> {
                    pedido.setStatus(StatusPedidoEnum.FECHADO);
                    pedidoDao.save(pedido);
                    return Boolean.TRUE;
                })
                .orElseThrow(() -> new ErroInternoException("Pedido não encontrado."));
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
