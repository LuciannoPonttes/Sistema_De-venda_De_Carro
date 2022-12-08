package br.atos.xlo.dto;

import com.fasterxml.jackson.annotation.JsonView;

import br.atos.xlo.controller.dto.base.View;
import io.swagger.v3.oas.annotations.media.Schema;

public class EnderecoDTO {

	@Schema(description = "Código do Endereço", example = "10", required = false)
	@JsonView(value = { View.ControllerView.GET.class, View.ControllerView.Public.class })
	private int codEndereco;

	@Schema(description = "CEP do Endereço", example = "'12345789'", required = false)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.GET.class, View.ControllerView.PUT.class,
			View.ControllerView.Public.class })
	private String cep;

	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.GET.class, View.ControllerView.PUT.class,
			View.ControllerView.Public.class })
	private String logradouro;

	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.GET.class, View.ControllerView.PUT.class,
			View.ControllerView.Public.class })
	private String bairro;

	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.GET.class, View.ControllerView.PUT.class,
			View.ControllerView.Public.class })
	private String cidade;

	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.GET.class, View.ControllerView.PUT.class,
			View.ControllerView.Public.class })
	private String estado;

	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.GET.class, View.ControllerView.PUT.class,
			View.ControllerView.Public.class })
	private int numero;

	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.GET.class, View.ControllerView.PUT.class,
			View.ControllerView.Public.class })
	private String complemento;

	@JsonView(value = { View.ControllerView.GET.class, View.ControllerView.Internal.class })
	private UsuarioDTO usuario;
}
