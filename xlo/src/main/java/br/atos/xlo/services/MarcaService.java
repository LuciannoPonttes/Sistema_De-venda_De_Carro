package br.atos.xlo.services;

import java.util.List;

import br.atos.xlo.dto.MarcaDTO;

public interface MarcaService {

	List<MarcaDTO> listar(String descricao);
}
