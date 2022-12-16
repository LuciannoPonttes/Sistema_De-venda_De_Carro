package br.atos.xlo.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.atos.xlo.controller.request.RelatorioCustomQuery;
import br.atos.xlo.dto.UsuarioDTO;
import br.atos.xlo.dto.VeiculoDTO;

public interface RelatorioService {

	public Page<UsuarioDTO> gerarRelatorioUsuarios(RelatorioCustomQuery relatorioCustomQuery, Pageable pageable);

	public Page<VeiculoDTO> gerarRelatorioVeiculos(RelatorioCustomQuery relatorioCustomQuery, Pageable pageable);
}
