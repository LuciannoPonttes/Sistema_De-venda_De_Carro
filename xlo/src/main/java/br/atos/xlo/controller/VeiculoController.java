package br.atos.xlo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.atos.xlo.controller.dto.base.View;
import br.atos.xlo.controller.dto.base.response.ResponseNodePagination;
import br.atos.xlo.dto.VeiculoDTO;
import br.atos.xlo.services.VeiculoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

/**
 * Classe que será utilizada para as operações de veículos
 * 
 * @author taao_
 *
 */
//Data: 30-11-2022

@Api(tags = "veiculo")
@RestController
@RequestMapping("/api/veiculo")
public class VeiculoController {

	@Autowired
	VeiculoServiceImpl veiculoService;

	@Operation(summary = "Adicionar Veículo")
	@PostMapping(produces = "application/json")
	@JsonView(View.ControllerView.Public.class)
	public VeiculoDTO adicionar(@JsonView(value = {
			View.ControllerView.POST.class }) @RequestBody(required = true) @Valid VeiculoDTO veiculoDTO) {

		return veiculoService.adicionar(veiculoDTO);
	}

	@Operation(summary = "Editar Veículo")
	@PutMapping(produces = "application/json")
	@JsonView(View.ControllerView.Public.class)
	public VeiculoDTO editar(@JsonView(value = {
			View.ControllerView.PUT.class }) @RequestBody(required = true) @Valid VeiculoDTO veiculoDTO) {
		return veiculoService.editar(veiculoDTO);

	}

	@Operation(summary = "Excluir Veículo")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluir(@PathVariable(value = "id") Integer id) {
		veiculoService.excluir(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Operation(summary = "Listar Últimos Veículos")
	@GetMapping(produces = "application/json")
	@JsonView(View.ControllerView.Public.class)
	public ResponseNodePagination<VeiculoDTO> listarVeiculos(
			@RequestParam(value = "indice", required = true, defaultValue = "0") @Parameter(description = "Índice da página", required = true) int indice,
			@RequestParam(value = "tamPagina", required = true, defaultValue = "10") @Parameter(description = "Tamanho da página", required = true) int tamPagina,
			@RequestParam(value = "status", required = false) @Parameter(description = "status do veículo", example = "1", required = false) Integer status) {
		Pageable pageable = PageRequest.of(indice, tamPagina, Direction.DESC, "DTH_INCLUSAO");

		Page<VeiculoDTO> page = veiculoService.listarVeiculos(pageable, status);
		return new ResponseNodePagination<>(HttpStatus.OK, page);
	}

}
