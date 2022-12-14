package br.atos.xlo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.atos.xlo.controller.dto.base.View;
import br.atos.xlo.dto.MarcaDTO;
import br.atos.xlo.services.MarcaServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@Api(tags = "marca")
@RestController
@RequestMapping("/api/marca")
public class MarcaController {

	@Autowired
	MarcaServiceImpl marcaService;

	@Operation(summary = "Listar Marcas de Veículos")
	@GetMapping(produces = "application/json")
	@JsonView(View.ControllerView.Public.class)
	public List<MarcaDTO> listar(
			@RequestParam(value = "descricao", required = false) @Parameter(description = "Descrição da marca", example = "Audi", required = false) String descricao,
			@RequestParam(value = "id", required = false) @Parameter(description = "ID da marca", example = "1", required = false) Long id
	) {
		return marcaService.listar();
	}
}
