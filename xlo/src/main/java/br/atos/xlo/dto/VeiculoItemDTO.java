package br.atos.xlo.dto;

import br.atos.xlo.model.VeiculoItem;

public class VeiculoItemDTO {
	
	private int codigoItem;

	private String descricaoItem;
	
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
}
