package br.atos.xlo.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

import br.atos.xlo.controller.dto.base.View;
import br.atos.xlo.controller.dto.base.response.Body;
import io.swagger.v3.oas.annotations.media.Schema;

public class ModeloDTO implements Body {

	@Schema(description = "Código do Modelo", example = "1", required = false)
	@JsonView(value = { View.ControllerView.GET.class, View.ControllerView.POST.class, View.ControllerView.PUT.class,
			View.ControllerView.Public.class })
	private int codigoModelo;

	@Schema(description = "Descrição do Modelo", example = "Monza Class1.8/ 2.0", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.POST.class, View.ControllerView.PUT.class,
			View.ControllerView.Public.class })
	@NotNull
	@NotBlank
	private String descricaoModelo;

	@Schema(description = "Marca do Veículo", required = false)
	@JsonView(value = { View.ControllerView.Internal.class })
	@Valid
	private MarcaDTO marca;

	@Schema(description = "Categoria do Veículo", required = false)
	@JsonView(value = { View.ControllerView.Internal.class })
	@Valid
	private CategoriaDTO categoria;

	public ModeloDTO(int codigoModelo, @NotNull @NotBlank String descricaoModelo, @Valid MarcaDTO marca) {
		super();
		this.codigoModelo = codigoModelo;
		this.descricaoModelo = descricaoModelo;
		this.marca = marca;
	}

	public ModeloDTO(int codigoModelo, @NotNull @NotBlank String descricaoModelo, @Valid MarcaDTO marca,
			@Valid CategoriaDTO categoria) {
		super();
		this.codigoModelo = codigoModelo;
		this.descricaoModelo = descricaoModelo;
		this.marca = marca;
		this.categoria = categoria;
	}

	public ModeloDTO() {
		super();
	}

	public MarcaDTO getMarca() {
		return marca;
	}

	public void setMarca(MarcaDTO marca) {
		this.marca = marca;
	}

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

	public CategoriaDTO getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}

}
