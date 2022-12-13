package br.atos.xlo.controller;

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
import br.atos.xlo.dto.VeiculoDTO;
import br.atos.xlo.services.VeiculoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;


/**
 * Classe que será utilizada para as operações de veículos
 * @author taao_
 *
 */
//Data: 30-11-2022

@Api(tags = "veiculo")
@RestController
@RequestMapping("/api/veiculo")
public class VeiculoController {

	@Autowired
	VeiculoServiceImpl veiculoService;
	
	@Operation(summary = "Adicionar Veículo")
	@PostMapping(produces = "application/json")
	@JsonView(View.ControllerView.Public.class)
	public String adicionar(@RequestBody VeiculoDTO veiculoDTO) {
		veiculoService.adicionar(veiculoDTO);
		return "Veiculo Criado";
	}
	
	@Operation(summary = "Listar Veículos")
	@GetMapping(produces = "application/json")
	@JsonView(View.ControllerView.Public.class)
	public String listar(@RequestParam(value="nome", required = false) String nome) {
		veiculoService.listar(nome);
		return "Veiculos Listados" + nome;
	}
	
	@Operation(summary = "Editar Veículo")
	@PutMapping(produces = "application/json")
	@JsonView(View.ControllerView.Public.class)
	public String editar(@RequestBody VeiculoDTO veiculoDTO) {
		veiculoService.editar(veiculoDTO);
		return "Veiculo Editado";
	}
	
	@Operation(summary = "Excluir Veículo")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluir(@PathVariable(value="id") Integer id) {
		veiculoService.excluir(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
