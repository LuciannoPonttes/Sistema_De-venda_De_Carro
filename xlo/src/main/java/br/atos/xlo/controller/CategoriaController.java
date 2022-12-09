package br.atos.xlo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.atos.xlo.dto.CategoriaDTO;
import br.atos.xlo.services.CategoriaService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(tags = "Veículo Categoria")
@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService service;
	
	@Operation(summary = "Listar categorias de veículos")
	@GetMapping(produces = "application/json")
	@ApiResponses(value = { @ApiResponse(content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CategoriaDTO.class))) }) })
	private List<CategoriaDTO> listar() {
		return service.listar();
	}
}
