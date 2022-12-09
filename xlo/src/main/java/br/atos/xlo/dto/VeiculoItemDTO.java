package br.atos.xlo.dto;

import com.fasterxml.jackson.annotation.JsonView;

import br.atos.xlo.controller.dto.base.View;
import br.atos.xlo.model.VeiculoItem;
import io.swagger.v3.oas.annotations.media.Schema;

public class VeiculoItemDTO {

	@Schema(example = "45")
	@JsonView(value= { View.ControllerView.GET.class, View.ControllerView.Public.class })
	private int codigoItem;

	@Schema(example = "Ar condicionado")
	@JsonView(value= { View.ControllerView.GET.class, View.ControllerView.Public.class })
	private String descricaoItem;

	@Schema(example = "1")
	@JsonView(value = { View.ControllerView.Internal.class })
	private int statusRegistro;

	public VeiculoItemDTO(int codigoItem, String descricaoItem, int statusRegistro) {
		this.codigoItem = codigoItem;
		this.descricaoItem = descricaoItem;
		this.statusRegistro = statusRegistro;
	}

	public int getCodigoItem() {
		return codigoItem;
	}

	public void setCodigoItem(int codigoItem) {
		this.codigoItem = codigoItem;
	}

	public String getDescricaoItem() {
		return descricaoItem;
	}

	public void setDescricaoItem(String descricaoItem) {
		this.descricaoItem = descricaoItem;
	}

	public int getStatusRegistro() {
		return statusRegistro;
	}

	public void setStatusRegistro(int statusRegistro) {
		this.statusRegistro = statusRegistro;
	}

	public static VeiculoItemDTO from(VeiculoItem item) {
		return new VeiculoItemDTO(item.getCodigoItem(), item.getDescricaoItem(), item.getStatusRegistro());
	}

	public VeiculoItemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
