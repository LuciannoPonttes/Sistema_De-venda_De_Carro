package br.atos.xlo.services;

import java.util.List;

import br.atos.xlo.dto.MarcaDTO;

public interface MarcaService {

	List<MarcaDTO> listar(String descricao);

	public void adicionarMarca(MarcaDTO marcaDTO);

	public void adicionarMarcas(List<MarcaDTO> marcasDTO);
}
