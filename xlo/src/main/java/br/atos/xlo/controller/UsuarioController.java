package br.atos.xlo.controller;

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

import br.atos.xlo.dto.UsuarioDTO;
import br.atos.xlo.services.UsuarioServiceImpl;

//Classe que será utilizada para as operações de usuários
//Data: 30-11-2022

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired
	UsuarioServiceImpl usuarioService;
	
	
	@PostMapping
	public String adicionar(@RequestBody UsuarioDTO usuarioDTO) {
		usuarioService.adicionar(usuarioDTO);
		return "Usuario Criado";
	}
	
	@GetMapping
	public String listar(@RequestParam(value="nome", required = false) String nome) {
		usuarioService.listar(nome);
		return "Usuarios Listados" + nome;
	}
	
	@PutMapping
	public String editar(@RequestBody UsuarioDTO usuarioDTO) {
		usuarioService.editar(usuarioDTO);
		return "Usuario Editado";
	}
	
	@DeleteMapping(value= "/{id}")
	public String excluir(@PathVariable(value="id") Long id) {
		usuarioService.excluir(id);
		return "Usuario Excluído " + id;
	}

	
	
	
}
