package br.atos.xlo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.atos.xlo.repository.ArquivoRepository;
import br.atos.xlo.repository.EnderecoRepository;
import br.atos.xlo.repository.RoleRepository;

@RestController
@RequestMapping("/api/arquivo")
public class ArquivoController {

	@Autowired
	ArquivoRepository arquivoRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
}
