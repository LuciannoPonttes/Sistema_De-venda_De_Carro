package br.atos.xlo.dto;

import com.fasterxml.jackson.annotation.JsonView;

import br.atos.xlo.controller.dto.base.View;
import br.atos.xlo.model.Veiculo;
import io.swagger.v3.oas.annotations.media.Schema;

public class CategoriaDTO {

	@Schema(description = "Código da Categoria", example = "'1'", required = false)
	@JsonView(value = { View.ControllerView.GET.class, View.ControllerView.Public.class })
	private int codigoCategoria;

	@Schema(description = "Descrição da Categoria", example = "Motos", required = false)
	@JsonView(value = { View.ControllerView.GET.class, View.ControllerView.Public.class })
	private String descricaoCategoria;

	@Schema(description = "Veículos da Categoria", required = false)
	@JsonView(value = { View.ControllerView.Internal.class })
	private Veiculo veiculo;

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

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

}
