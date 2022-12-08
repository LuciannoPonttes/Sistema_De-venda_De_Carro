package br.atos.xlo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.atos.xlo.controller.dto.base.View;
import br.atos.xlo.dto.VeiculoItemDTO;
import br.atos.xlo.services.VeiculoItemService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Api(tags = "Veículo Item Opcional")
@RestController
@RequestMapping("/api/veiculo-item")
public class VeiculoItemController {

	@Autowired
	private VeiculoItemService veiculoItemService;

	@Operation(summary = "Listar items opcionais de um veículo")
	@GetMapping(produces = "application/json")
	@ApiResponses(value = { @ApiResponse(content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = VeiculoItemDTO.class))) }) })
	@JsonView(value = { View.ControllerView.GET.class, View.ControllerView.Public.class })
	public List<VeiculoItemDTO> listarItemsVeiculo() {
		return veiculoItemService.listar();
	}

}
