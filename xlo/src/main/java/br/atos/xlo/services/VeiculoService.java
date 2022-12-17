package br.atos.xlo.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.atos.xlo.dto.VeiculoDTO;
import br.atos.xlo.enums.StatusVeiculoEnum;

public interface VeiculoService {

	public VeiculoDTO adicionar(VeiculoDTO veiculoDTO);
	public List<VeiculoDTO> listar();
	public void excluir(Integer id);
	public VeiculoDTO editar(VeiculoDTO veiculoDTO);
	public Page<VeiculoDTO> listarVeiculos(Pageable pageable, Integer status);
	public void alterarStatus(Integer id, StatusVeiculoEnum status);
	
}
