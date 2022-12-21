package br.atos.xlo.services;

import java.util.List;

import br.atos.xlo.dto.ReferenciaFipeDTO;

public interface ReferenciaFipeService {

	public List<ReferenciaFipeDTO> adicionar(List<ReferenciaFipeDTO> referenciaFipeDTO);

	public Integer buscaCodigoTabelaReferencia();
}
