package br.com.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.dto.PedidoDTO;
import br.com.api.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService service;
	
	@GetMapping
	public List<PedidoDTO> listarPedidos() {
		return service.listarPedidos();
	}
	
	@GetMapping("/busca/{codigo}")
	public PedidoDTO buscarPedido(Integer codigo) {
		return service.buscarPedido(codigo);
	}
	
	@GetMapping("/fecha/{codigo}")
	public void fecharPedido(Integer codigo) {
		service.fecharPedido(codigo);
	}
	
	@PutMapping
	public void atualizarPedido(PedidoDTO pedidoDTO) {
		service.atualizarPedido(pedidoDTO);
	}

	@PostMapping
	public void salvarPedido(PedidoDTO pedidoDTO) {
		service.salvarPedido(pedidoDTO);
	}
	
	@DeleteMapping
	public void excluirPedido() {
		
	}
	
}
