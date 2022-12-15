package br.atos.xlo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.atos.xlo.controller.dto.base.View;
import br.atos.xlo.dto.UsuarioDTO;
import br.atos.xlo.services.UsuarioServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@Api(tags = "usuario")
@RestController
@RequestMapping(value = "/api/usuario")
public class UsuarioController {

	@Autowired
	UsuarioServiceImpl usuarioService;

	@Operation(summary = "Adicionar Usuário")
	@PostMapping(produces = "application/json")
	@JsonView(View.ControllerView.Public.class)
	public UsuarioDTO adicionar(@JsonView(value = {
			View.ControllerView.POST.class }) @RequestBody(required = true) @Valid UsuarioDTO usuario) {
		return usuarioService.adicionar(usuario);
	}

	@Operation(summary = "Editar Usuário")
	@PutMapping(produces = "application/json")
	@JsonView(View.ControllerView.Public.class)
	public UsuarioDTO editar(@JsonView(value = {
			View.ControllerView.PUT.class }) @RequestBody(required = true) @Valid UsuarioDTO usuario) {
		return usuarioService.editar(usuario);
	}

	@Operation(summary = "Excluir Usuário")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluir(
			@PathVariable(value = "id") @Parameter(description = "ID do usuário para ser deletado", example = "1", required = true) int id) {

		usuarioService.excluir(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
