package br.atos.xlo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.atos.xlo.dto.VeiculoItemDTO;
import br.atos.xlo.services.VeiculoItemService;

@RestController
@RequestMapping("/api/veiculo-item")
public class VeiculoItemController {
	
	@Autowired
	private VeiculoItemService veiculoItemService;
	
	@GetMapping
	public List<VeiculoItemDTO> listarItemsVeiculo() {
		return veiculoItemService.listar();
	}
	
}
