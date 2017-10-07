package br.com.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@GetMapping
	public void listarPedido() {
		
	}
	
	@GetMapping("/busca/{codigo}")
	public void buscarPedido() {
		
	}
	
	@GetMapping("/fecha/{codigo}")
	public void fecharPedido() {
		
	}
	
	@PutMapping
	public void atualizarPedido() {
		
	}

	@PostMapping
	public void salvarPedido() {
		
	}
	
}
