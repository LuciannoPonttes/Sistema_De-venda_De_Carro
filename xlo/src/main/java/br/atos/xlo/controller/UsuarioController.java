package br.atos.xlo.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.atos.xlo.dto.UsuarioDTO;
import br.atos.xlo.services.UsuarioServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

//Classe que será utilizada para as operações de usuários
//Data: 30-11-2022

@RestController @RequestMapping(value="/api/usuario")

public class UsuarioController {

	@Autowired
	UsuarioServiceImpl usuarioService;

	@Operation(summary = "Adicionar Usuário")
	@PostMapping
	public UsuarioDTO adicionar(@JsonView(value = {
			View.ControllerView.POST.class }) @Valid @RequestBody(required = true) UsuarioDTO usuario) {
		return usuarioService.adicionar(usuario);
	}

	@Operation(summary = "Listar Usuários")
	@ApiResponses(value = { @ApiResponse(content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UsuarioDTO.class))) }) })

	@GetMapping
	public List<UsuarioDTO> listar(@RequestParam(value = "nome", required = false) String nome) {
		usuarioService.listar(nome);

		return Arrays.asList(new UsuarioDTO());
	}

	@Operation(summary = "Editar Usuário")
	@PutMapping
	public UsuarioDTO editar(@JsonView(value = {
			View.ControllerView.PUT.class }) @Valid @RequestBody(required = true) UsuarioDTO usuario) {
		return usuarioService.editar(usuario);
	}

	@Operation(summary = "Excluir Usuário")
	@DeleteMapping(value = "/{id}")
	public String excluir(@PathVariable(value = "id") Long id) {

		usuarioService.excluir(id);
		return "Usuario Excluído " + id;
	}

}
