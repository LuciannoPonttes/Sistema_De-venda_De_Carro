package br.atos.xlo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.atos.xlo.controller.request.RelatorioCustomQuery;
import br.atos.xlo.dto.UsuarioDTO;
import br.atos.xlo.dto.VeiculoDTO;

@Service
public class RelatorioServiceImpl implements RelatorioService {

	public List<UsuarioDTO> gerarRelatorioUsuarios(RelatorioCustomQuery relatorioCustomQuery) {

		return null;
	}

	@Override
	public List<VeiculoDTO> gerarRelatorioVeiculos(RelatorioCustomQuery relatorioCustomQuery) {
		
		return null;
	}
}
