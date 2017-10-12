package br.com.api.mapper;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import br.com.api.dto.ItemPedidoDTO;
import br.com.api.dto.PedidoDTO;
import br.com.api.entidades.ItemPedido;
import br.com.api.entidades.Pedido;

public class PedidoMapper extends AbstractMapper<PedidoDTO, Pedido> {

	@Override
	public Pedido converterDe(PedidoDTO de) {
		if(de == null) {
			return null;
		}
		
		Pedido para = new Pedido();
		para.setCliente(de.getCliente());
		para.setCodigo(de.getCodigo());
		para.setDataPedido(de.getDataPedido());
		para.setItensPedido(converterItemPedido(de.getItensPedido()));
		para.setStatus(de.getStatus());
		para.setTelefone(de.getTelefone());
		para.setValorTotalPedido(de.getValorTotalPedido());
		
		adicionarReferenciaPedido(para);
		
		return para;
	}

	private List<ItemPedido> converterItemPedido(List<ItemPedidoDTO> itensPedidoDTO) {
		return new ItemPedidoMapper().converterDe(itensPedidoDTO);
	}
	
	private void adicionarReferenciaPedido(Pedido para) {
		if(para == null) {
			return;
		}
		
		List<ItemPedido> itensPedido = para.getItensPedido();
		
		if(CollectionUtils.isNotEmpty(itensPedido)) {
			for (ItemPedido itemPedido : itensPedido) {
				itemPedido.setPedido(para);
			}
		}
		
	}
}
 