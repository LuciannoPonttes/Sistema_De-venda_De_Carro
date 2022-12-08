package br.atos.xlo.services;

import br.atos.xlo.dto.VeiculoDTO;

public interface VeiculoService {

	public VeiculoDTO adicionar(VeiculoDTO veiculoDTO);
	public VeiculoDTO listar(String descricao);
	public VeiculoDTO excluir(Long id);
	public VeiculoDTO editar(VeiculoDTO veiculoDTO);
	
}
