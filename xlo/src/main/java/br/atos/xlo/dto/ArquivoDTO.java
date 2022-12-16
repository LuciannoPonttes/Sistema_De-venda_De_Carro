package br.atos.xlo.dto;

import com.fasterxml.jackson.annotation.JsonView;

import br.atos.xlo.controller.dto.base.View;

public class ArquivoDTO {

	@JsonView(value = { View.ControllerView.GET.class, View.ControllerView.PUT.class,
			View.ControllerView.Public.class })
	private int codArquivo;

	@JsonView(value = { View.ControllerView.GET.class, View.ControllerView.POST.class, View.ControllerView.PUT.class,
			View.ControllerView.Public.class })
	private String endArquivo;

	public ArquivoDTO() {
		super();
	}

	public int getCodArquivo() {
		return codArquivo;
	}

	public void setCodArquivo(int codArquivo) {
		this.codArquivo = codArquivo;
	}

	public String getEndArquivo() {
		return endArquivo;
	}

	public void setEndArquivo(String endArquivo) {
		this.endArquivo = endArquivo;
	}

}