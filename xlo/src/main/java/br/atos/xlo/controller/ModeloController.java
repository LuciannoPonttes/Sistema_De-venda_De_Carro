package br.atos.xlo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.atos.xlo.controller.dto.base.View;
import br.atos.xlo.dto.ModeloDTO;
import br.atos.xlo.services.ModeloServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@Api(tags = "modelo")
@RestController
@RequestMapping("/api/modelo")
public class ModeloController {

	@Autowired
	ModeloServiceImpl modeloService;

	@Operation(summary = "Listar Modelos de Veículos")
	@GetMapping(produces = "application/json")
	@JsonView(View.ControllerView.Public.class)
	public List<ModeloDTO> listar(
			@RequestParam(value = "descricao", required = false) @Parameter(description = "Descrição do modelo", example = "A3", required = false) String descricao,
			@RequestParam(value = "id", required = false) @Parameter(description = "ID do modelo", example = "1", required = false) Long id

	) {
		return modeloService.listar();
	}
}
