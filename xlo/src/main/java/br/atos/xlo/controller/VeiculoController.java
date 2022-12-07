package br.atos.xlo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.atos.xlo.repository.CategoriaRepository;
import br.atos.xlo.repository.MarcaRepository;
import br.atos.xlo.repository.ModeloRepository;
import br.atos.xlo.repository.VeiculoItemRepository;
import br.atos.xlo.repository.VeiculoRepository;

/**
 * Classe que será utilizada para as operações de veículos
 * @author taao_
 *
 */
//Data: 30-11-2022

@RestController
@RequestMapping("/api/veiculo")
public class VeiculoController {

	@Autowired
	VeiculoRepository veiculoRepository;
	
	@Autowired
	ModeloRepository modeloRepository;
	
	@Autowired
	MarcaRepository marcaRepository;
	
	@Autowired
	VeiculoItemRepository veiculoItemRepository;
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	
	
	
}
