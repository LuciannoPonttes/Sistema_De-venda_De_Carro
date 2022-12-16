package br.atos.xlo.dto;

import com.fasterxml.jackson.annotation.JsonView;

import br.atos.xlo.controller.dto.base.View;
import br.atos.xlo.controller.dto.base.response.Body;
import io.swagger.v3.oas.annotations.media.Schema;

public class CategoriaDTO implements Body {

	@Schema(description = "Código da Categoria", example = "1", required = false)
	@JsonView(value = { View.ControllerView.GET.class, View.ControllerView.POST.class, View.ControllerView.PUT.class,
			View.ControllerView.Public.class })
	private int codigoCategoria;

	@Schema(description = "Descrição da Categoria", example = "Carros e Utilitários", required = false)
	@JsonView(value = { View.ControllerView.GET.class, View.ControllerView.POST.class, View.ControllerView.PUT.class,
			View.ControllerView.Public.class })
	private String descricaoCategoria;


	public int getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(int codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}

}
