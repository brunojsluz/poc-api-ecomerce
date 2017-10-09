package br.com.api.mapper;

import br.com.api.dto.PedidoDTO;
import br.com.api.entidades.Pedido;

public class PedidoMapper extends AbstractMapper<PedidoDTO, Pedido> {

	@Override
	public Pedido converterDe(PedidoDTO de) {
		Pedido para = new Pedido();
		para.setCliente(de.getCliente());
		para.setCodigo(de.getCodigo());
		para.setDataPedido(de.getDataPedido());
		//para.setItensPedido(de.getItensPedido());
		para.setStatus(de.getStatus());
		para.setTelefone(de.getTelefone());
		para.setValorTotalPedido(de.getValorTotalPedido());
		return para;
	}

}
