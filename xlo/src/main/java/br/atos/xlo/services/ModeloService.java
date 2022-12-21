package br.atos.xlo.services;

import java.util.List;

import br.atos.xlo.dto.ModeloDTO;

public interface ModeloService {

	public List<ModeloDTO> listar(String descricao);

	public ModeloDTO adicionarModelo(ModeloDTO modeloDTO);

	public List<ModeloDTO> adicionarModelos(List<ModeloDTO> modelosDTO);
}
