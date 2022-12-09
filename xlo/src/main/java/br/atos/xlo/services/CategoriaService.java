package br.atos.xlo.services;

import java.util.List;

import br.atos.xlo.dto.CategoriaDTO;

public interface CategoriaService {
	
	public CategoriaDTO adicionar(CategoriaDTO categoriaDTO);
	public List<CategoriaDTO> listar();
	public CategoriaDTO excluir(Long id);
	public CategoriaDTO editar(CategoriaDTO categoriaDTO);
}
