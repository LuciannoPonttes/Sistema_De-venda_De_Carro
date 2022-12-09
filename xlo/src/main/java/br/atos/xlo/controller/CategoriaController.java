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
import br.atos.xlo.dto.CategoriaDTO;

import br.atos.xlo.services.CategoriaServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@Api(tags = "categoria")

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
	
	@Autowired

	CategoriaServiceImpl categoriaService;

	@Operation(summary = "Listar Categorias")
	@GetMapping(produces = "application/json")
	@JsonView(View.ControllerView.Public.class)
	public List<CategoriaDTO> listar(@RequestParam(value = "Nome do categoria", required = false) String categoria) {
		categoriaService.listar();

		return Arrays.asList(new CategoriaDTO());
	}

	@Operation(summary = "Adicionar categoria")
	@PostMapping(produces = "application/json")
	@JsonView(View.ControllerView.Public.class)
	public CategoriaDTO adicionar(@JsonView(value = {
			View.ControllerView.POST.class }) @RequestBody(required = true) @Valid CategoriaDTO categoria) {
		return categoriaService.adicionar(categoria);

	}

	@Operation(summary = "Editar categoria")
	@PutMapping(produces = "application/json")
	@JsonView(View.ControllerView.Public.class)
	public CategoriaDTO editar(@JsonView(value = {
			View.ControllerView.PUT.class }) @RequestBody(required = true) @Valid CategoriaDTO categoria) {
		return categoriaService.editar(categoria);
	}

	@Operation(summary = "Excluir categoria")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluir(
			@PathVariable(value = "id") @Parameter(description = "ID do categoria para ser deletado", example = "1", required = true) Long id) {

		categoriaService.excluir(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	
}
