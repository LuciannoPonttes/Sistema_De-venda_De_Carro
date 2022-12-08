package br.atos.xlo.dto;

import com.fasterxml.jackson.annotation.JsonView;

import br.atos.xlo.controller.dto.base.View;

public class EnderecoDTO {

	@JsonView(value = { View.ControllerView.GET.class })
	private int codEndereco;

	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.GET.class, View.ControllerView.PUT.class })
	private String cep;

	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.GET.class, View.ControllerView.PUT.class })
	private String logradouro;

	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.GET.class, View.ControllerView.PUT.class })
	private String bairro;

	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.GET.class, View.ControllerView.PUT.class })
	private String cidade;

	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.GET.class, View.ControllerView.PUT.class })
	private String estado;

	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.GET.class, View.ControllerView.PUT.class })
	private int numero;

	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.GET.class, View.ControllerView.PUT.class })
	private String complemento;

	@JsonView(value = { View.ControllerView.GET.class })
	private UsuarioDTO usuario;
}
