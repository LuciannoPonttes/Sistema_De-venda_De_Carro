package br.atos.xlo.services;

import java.util.List;

import br.atos.xlo.dto.ArquivoDTO;

public interface ArquivoService {

	public ArquivoDTO adicionar(ArquivoDTO arquivoDTO);
	public List<ArquivoDTO> listar();
	public ArquivoDTO excluir(Long id);
	public ArquivoDTO editar(ArquivoDTO arquivoDTO);
	
}
