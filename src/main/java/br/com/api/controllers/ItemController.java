package br.com.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	
	@GetMapping("/busca/parcial")
	public List<ItemDTO> buscarPorDescricao(@RequestParam("descricao") String descricao) {
		return service.buscarPorDescricao(descricao);
	}
	
	@PostMapping("/altera/preco")
	public void alteraPrecoItem(@RequestBody AlteraPrecoDTO alteraPreco) {
		service.alteraPrecoItem(alteraPreco);
	}
	
	@PutMapping
	public void alteraItem(@RequestBody ItemDTO itemDTO) {
		service.alteraItem(itemDTO);
	}
	
	@PostMapping
	public void salvarItem(@RequestBody ItemDTO itemDTO) {
		service.salvarItem(itemDTO);
	}
	
	@DeleteMapping
	public void escluirItem(@RequestBody ItemDTO itemDTO) {
		service.excluirItem(itemDTO);
	}
}