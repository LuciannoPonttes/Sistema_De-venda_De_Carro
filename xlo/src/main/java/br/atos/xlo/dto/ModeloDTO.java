package br.atos.xlo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

import br.atos.xlo.controller.dto.base.View;
import io.swagger.v3.oas.annotations.media.Schema;

public class ModeloDTO {

	
	@Schema(description = "Código do Modelo", example = "1", required = false)
	@JsonView(value = { View.ControllerView.GET.class, View.ControllerView.PUT.class })
	private int codigoModelo;

	@Schema(description = "Descrição do Modelo", example = "Monza Class1.8/ 2.0", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.PUT.class, View.ControllerView.GET.class })
	@NotNull
	@NotBlank
	private String descricaoModelo;


	public int getCodigoModelo() {
		return codigoModelo;
	}

	public void setCodigoModelo(int codigoModelo) {
		this.codigoModelo = codigoModelo;
	}

	public String getDescricaoModelo() {
		return descricaoModelo;
	}

	public void setDescricaoModelo(String descricaoModelo) {
		this.descricaoModelo = descricaoModelo;
	}

	
		
}
