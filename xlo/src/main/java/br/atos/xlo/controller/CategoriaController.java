package br.atos.xlo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.atos.xlo.controller.dto.base.View;
import br.atos.xlo.dto.CategoriaDTO;
import br.atos.xlo.services.CategoriaServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;

@Api(tags = "categoria")

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

	@Autowired
	CategoriaServiceImpl categoriaService;

	@Operation(summary = "Listar Categorias")
	@GetMapping(produces = "application/json")
	@JsonView(View.ControllerView.Public.class)
	public List<CategoriaDTO> listar(@RequestParam(value = "Nome do categoria", required = false) String categoria) {
		return categoriaService.listar();
	}

}
