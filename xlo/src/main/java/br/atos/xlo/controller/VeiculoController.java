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



import br.atos.xlo.repository.VeiculoRepository;

import br.atos.xlo.dto.VeiculoDTO;
import br.atos.xlo.services.VeiculoServiceImpl;


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
	VeiculoServiceImpl veiculoService;
	
	@PostMapping
	public String adicionar(@RequestBody VeiculoDTO veiculoDTO) {
		veiculoService.adicionar(veiculoDTO);
		return "Veiculo Criado";
	}
	
	@GetMapping
	public String listar(@RequestParam(value="nome", required = false) String nome) {
		veiculoService.listar(nome);
		return "Veiculos Listados" + nome;
	}
	
	@PutMapping
	public String editar(@RequestBody VeiculoDTO veiculoDTO) {
		veiculoService.editar(veiculoDTO);
		return "Veiculo Editado";
	}
	
	@DeleteMapping(value= "/{id}")
	public String excluir(@PathVariable(value="id") Long id) {
		veiculoService.excluir(id);
		return "Veiculo Excluído " + id;
	}
	

}
