package br.atos.xlo.services;

import java.util.List;

import br.atos.xlo.dto.VeiculoDTO;

public interface VeiculoService {

	public VeiculoDTO adicionar(VeiculoDTO veiculoDTO);
	public List<VeiculoDTO> listar();
	public void excluir(Integer id);
	public VeiculoDTO editar(VeiculoDTO veiculoDTO);
	public List<VeiculoDTO> listarRecentes();
	
}
