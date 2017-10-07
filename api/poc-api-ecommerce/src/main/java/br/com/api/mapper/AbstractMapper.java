package br.com.api.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

public abstract class AbstractMapper<DE, PARA> implements Mapper<DE, PARA> {
	
	@Override
	public List<PARA> converterDe(List<DE> listaDe) {
		if(CollectionUtils.isEmpty(listaDe)) {
			return null;
		}
		
		List<PARA> lista = new ArrayList<>();
		
		for (DE de : listaDe) {
			if(de != null) {
				lista.add(converterDe(de));
			}
		}
		
		return lista;
	}

}
