package br.atos.xlo.services;

import java.util.List;

import br.atos.xlo.dto.VeiculoItemDTO;

public interface VeiculoItemService {
	
	public VeiculoItemDTO adicionar(VeiculoItemDTO veiculoItemDTO);
	public List<VeiculoItemDTO> listar();
	public VeiculoItemDTO excluir(Long id);
	public VeiculoItemDTO editar(VeiculoItemDTO veiculoItemDTO);
	
}
