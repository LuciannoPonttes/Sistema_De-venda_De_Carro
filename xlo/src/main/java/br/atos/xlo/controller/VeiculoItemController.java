package br.atos.xlo.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.atos.xlo.dto.VeiculoItemDTO;
import br.atos.xlo.services.VeiculoItemServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@Api(tags = "item veiculo")
@RestController
@RequestMapping("/api/veiculo-item")
public class VeiculoItemController {
	
	@Autowired
	VeiculoItemServiceImpl veiculoItemService;

	@Operation(summary = "Listar Item do veículos")
	@GetMapping(produces = "application/json")
	@JsonView(View.ControllerView.Public.class)
	public List<VeiculoItemDTO> listar(@RequestParam(value = "Nome do Item do veículo", required = false) String item) {
		veiculoItemService.listar();

		return Arrays.asList(new VeiculoItemDTO());
	}

	@Operation(summary = "Adicionar Item do veículo")
	@PostMapping(produces = "application/json")
	@JsonView(View.ControllerView.Public.class)
	public VeiculoItemDTO adicionar(@JsonView(value = {
			View.ControllerView.POST.class }) @RequestBody(required = true) @Valid VeiculoItemDTO veiculoItem) {
		return veiculoItemService.adicionar(veiculoItem);
	}

	@Operation(summary = "Editar Item do veículo")
	@PutMapping(produces = "application/json")
	@JsonView(View.ControllerView.Public.class)
	public VeiculoItemDTO editar(@JsonView(value = {
			View.ControllerView.PUT.class }) @RequestBody(required = true) @Valid VeiculoItemDTO veiculoItem) {
		return veiculoItemService.editar(veiculoItem);
	}

	@Operation(summary = "Excluir Item do veículo")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluir(
			@PathVariable(value = "id") @Parameter(description = "ID do item do veículo para ser deletado", example = "1", required = true) Long id) {

		veiculoItemService.excluir(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}