package br.atos.xlo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

import br.atos.xlo.controller.dto.base.View;
import br.atos.xlo.controller.dto.base.response.Body;
import io.swagger.v3.oas.annotations.media.Schema;

public class MarcaDTO implements Body {

	@Schema(description = "Código da Marca", example = "1", required = false)
	@JsonView(value = { View.ControllerView.GET.class, View.ControllerView.POST.class, View.ControllerView.PUT.class,
			View.ControllerView.Public.class })
	private int codigoMarca;

	@Schema(description = "Descrição da Marca", example = "GM - Chevrolet", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.PUT.class, View.ControllerView.GET.class,
			View.ControllerView.Public.class })
	@NotNull
	@NotBlank
	private String descricaoMarca;

	public int getCodigoMarca() {
		return codigoMarca;
	}

	public void setCodigoMarca(int codigoMarca) {
		this.codigoMarca = codigoMarca;
	}

	public String getDescricaoMarca() {
		return descricaoMarca;
	}

	public void setDescricaoMarca(String descricaoMarca) {
		this.descricaoMarca = descricaoMarca;
	}

}
