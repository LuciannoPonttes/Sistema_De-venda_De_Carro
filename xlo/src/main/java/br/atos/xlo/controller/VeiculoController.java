package br.atos.xlo.controller;

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
	public VeiculoDTO adicionar(@RequestBody VeiculoDTO veiculoDTO) {
		
		return veiculoService.adicionar(veiculoDTO);
	}

	@Operation(summary = "Editar Veículo")
	@PutMapping(produces = "application/json")
	@JsonView(View.ControllerView.Public.class)
	public VeiculoDTO editar(@RequestBody VeiculoDTO veiculoDTO) {
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
			@RequestParam(value = "pageIndex", required = true) @Parameter(description = "Índice que deseja consultar", example = "0", required = true) int pageIndex,
			@RequestParam(value = "size", required = true) @Parameter(description = "tamanho da página", example = "10", required = true) int size,
			@RequestParam(value = "status", required = true) @Parameter(description = "status do veículo", example = "1", required = true) int status) {
		Pageable pageable = PageRequest.of(pageIndex, size, Direction.DESC, "DTH_INCLUSAO");

		Page<VeiculoDTO> page = veiculoService.listarVeiculos(pageable, status);
		return new ResponseNodePagination<>(HttpStatus.OK, page);
	}

}
