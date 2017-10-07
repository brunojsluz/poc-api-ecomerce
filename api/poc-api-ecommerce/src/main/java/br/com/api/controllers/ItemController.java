package br.com.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.dto.AlteraPrecoDTO;
import br.com.api.dto.ItemDTO;
import br.com.api.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService service;
	
	@GetMapping
	public List<ItemDTO> listarItem() {
		return service.listarItem();
	}
	
	@GetMapping("/busca/{codigo}")
	public ItemDTO buscarItem(@PathVariable("codigo") Integer codigo) {
		return service.buscarItem(codigo);
	}
	
	@PostMapping("/altera/preco")
	public void alteraPrecoItem(AlteraPrecoDTO alteraPreco) {
		service.alteraPrecoItem(alteraPreco);
	}
	
	@PutMapping
	public void alteraItem(ItemDTO itemDTO) {
		service.alteraItem(itemDTO);
	}
	
	@PostMapping
	public void salvarItem(ItemDTO itemDTO) {
		service.salvarItem(itemDTO);
	}
}