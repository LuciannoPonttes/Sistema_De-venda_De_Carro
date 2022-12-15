package br.atos.xlo.services;

import java.util.List;

import br.atos.xlo.controller.request.RelatorioCustomQuery;
import br.atos.xlo.dto.UsuarioDTO;
import br.atos.xlo.dto.VeiculoDTO;

public interface RelatorioService {

	public List<UsuarioDTO> gerarRelatorioUsuarios(RelatorioCustomQuery relatorioCustomQuery);

	public List<VeiculoDTO> gerarRelatorioVeiculos(RelatorioCustomQuery relatorioCustomQuery);
}
