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
import br.atos.xlo.dto.ArquivoDTO;
import br.atos.xlo.services.ArquivoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@Api(tags = "arquivo")
@RestController
@RequestMapping("/api/arquivo")
public class ArquivoController {

	@Autowired
	ArquivoServiceImpl arquivoService;

	@Operation(summary = "Listar Arquivos")
	@GetMapping(produces = "application/json")
	@JsonView(View.ControllerView.Public.class)
	public List<ArquivoDTO> listar(@RequestParam(value = "Nome do arquivo", required = false) String nome) {
		arquivoService.listar();

		return Arrays.asList(new ArquivoDTO());
	}

	@Operation(summary = "Adicionar arquivo")
	@PostMapping(produces = "application/json")
	@JsonView(View.ControllerView.Public.class)
	public ArquivoDTO adicionar(@JsonView(value = {
			View.ControllerView.POST.class }) @RequestBody(required = true) @Valid ArquivoDTO arquivo) {
		return arquivoService.adicionar(arquivo);
	}

	@Operation(summary = "Editar arquivo")
	@PutMapping(produces = "application/json")
	@JsonView(View.ControllerView.Public.class)
	public ArquivoDTO editar(@JsonView(value = {
			View.ControllerView.PUT.class }) @RequestBody(required = true) @Valid ArquivoDTO arquivo) {
		return arquivoService.editar(arquivo);
	}

	@Operation(summary = "Excluir arquivo")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluir(
			@PathVariable(value = "id") @Parameter(description = "ID do arquivo para ser deletado", example = "1", required = true) Long id) {

		arquivoService.excluir(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	
}
