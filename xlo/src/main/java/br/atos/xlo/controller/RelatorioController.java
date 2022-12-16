package br.atos.xlo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.atos.xlo.controller.dto.base.View;
import br.atos.xlo.controller.dto.base.response.ResponseNodePagination;
import br.atos.xlo.controller.request.RelatorioCustomQuery;
import br.atos.xlo.dto.UsuarioDTO;
import br.atos.xlo.dto.VeiculoDTO;
import br.atos.xlo.services.RelatorioServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@Api(tags = "relatorio")
@RestController
@RequestMapping(value = "/api/relatorio")
public class RelatorioController {

	@Autowired
	RelatorioServiceImpl relatorioService;

	@Operation(summary = "Relatório de Usuários")
	@GetMapping(value = "/usuarios", produces = "application/json")
	@JsonView(View.ControllerView.Public.class)
	public ResponseNodePagination<UsuarioDTO> geraRelatorioUsuarios(
			@RequestParam(value = "indice", required = true, defaultValue = "0") @Parameter(description = "Índice da página", required = true) int indice,
			@RequestParam(value = "tamPagina", required = true, defaultValue = "10") @Parameter(description = "Tamanho da página", required = true) int tamPagina,
			@RequestParam(value = "situacao", required = false) @Parameter(description = "Situação do Usuário", required = false) Integer situacao,
			@RequestParam(value = "dataInicial", required = false) @Parameter(description = "Data Inicial", example = "2022-01-01T03:00:00.000Z", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dataInicial,
			@RequestParam(value = "dataFinal", required = false) @Parameter(description = "Data Final", example = "2022-01-01T03:00:00.000Z", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dataFinal) {

		Pageable pageable = PageRequest.of(indice, tamPagina);

		RelatorioCustomQuery relatorioCustomQuery = new RelatorioCustomQuery(situacao, dataInicial, dataFinal);

		Page<UsuarioDTO> page = relatorioService.gerarRelatorioUsuarios(relatorioCustomQuery, pageable);
		return new ResponseNodePagination<>(HttpStatus.OK, page);
	}

	@Operation(summary = "Relatório de Veículos")
	@GetMapping(value = "/veiculos", produces = "application/json")
	@JsonView(View.ControllerView.Public.class)
	public ResponseNodePagination<VeiculoDTO> geraRelatorioVeiculos(
			@RequestParam(value = "indice", required = true, defaultValue = "0") @Parameter(description = "Índice da página", required = true) int indice,
			@RequestParam(value = "tamPagina", required = true, defaultValue = "10") @Parameter(description = "Tamanho da página", required = true) int tamPagina,
			@RequestParam(value = "categoria", required = false) @Parameter(description = "Categoria do Veículo", example = "1", required = false) Integer categoria,
			@RequestParam(value = "situacao", required = false) @Parameter(description = "Situação do Usuário", required = false) Integer situacao,
			@RequestParam(value = "dataInicial", required = false) @Parameter(description = "Data Inicial", example = "1099-01-01T00:00:00.000Z", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dataInicial,
			@RequestParam(value = "dataFinal", required = false) @Parameter(description = "Data Final", example = "1099-01-01T00:00:00.000Z", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dataFinal) {

		Pageable pageable = PageRequest.of(indice, tamPagina);
		RelatorioCustomQuery relatorioCustomQuery = new RelatorioCustomQuery(categoria, situacao, dataInicial,
				dataFinal);
		Page<VeiculoDTO> page = relatorioService.gerarRelatorioVeiculos(relatorioCustomQuery, pageable);

		return new ResponseNodePagination<>(HttpStatus.OK, page);
	}
}
