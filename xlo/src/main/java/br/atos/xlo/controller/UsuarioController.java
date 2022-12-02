package br.atos.xlo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.atos.xlo.repository.UsuarioRepository;

//Classe que será utilizada para as operações de usuários
//Data: 30-11-2022

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	
	
	
	
}
