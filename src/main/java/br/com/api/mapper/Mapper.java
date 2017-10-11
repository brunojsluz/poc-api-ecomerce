package br.com.api.mapper;

import java.util.List;

public interface Mapper<DE, PARA> {
	
	public List<PARA> converterDe(List<DE> listaDe);
	
	public PARA converterDe(DE de);

}
