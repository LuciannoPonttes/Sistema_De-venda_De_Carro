package br.atos.xlo.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

import br.atos.xlo.controller.dto.base.View;
import br.atos.xlo.controller.dto.base.response.Body;
import io.swagger.v3.oas.annotations.media.Schema;

public class EnderecoDTO implements Body {

	@Schema(description = "Código do Endereço", example = "10", required = false)
	@JsonView(value = { View.ControllerView.GET.class, View.ControllerView.Public.class })
	private int codEndereco;

	@Size(min = 0, max = 8)
	@Schema(description = "CEP do Endereço", example = "'12345789'", required = false)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.GET.class, View.ControllerView.PUT.class,
			View.ControllerView.Public.class })
	private String cep;

	@Schema(description = "Logradouro do Endereço", example = "Avenida dos Perdidos", required = false)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.GET.class, View.ControllerView.PUT.class,
			View.ControllerView.Public.class })
	private String logradouro;

	@Schema(description = "Bairro do Endereço", example = "Bairro dos Esquecidos", required = false)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.GET.class, View.ControllerView.PUT.class,
			View.ControllerView.Public.class })
	private String bairro;

	@Schema(description = "Cidade do Endereço", example = "São Paulo", required = false)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.GET.class, View.ControllerView.PUT.class,
			View.ControllerView.Public.class })
	private String cidade;

	@Schema(description = "Estado do Endereço", example = "SP", required = false)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.GET.class, View.ControllerView.PUT.class,
			View.ControllerView.Public.class })
	@Size(min = 0, max = 2)
	private String estado;

	@Min(0)
	@Max(99999999)
	@Schema(description = "Número do Endereço", example = "'1099'", required = false)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.GET.class, View.ControllerView.PUT.class,
			View.ControllerView.Public.class })
	private int numero;

	@Schema(description = "Complemento do Endereço", example = "Apto 123", required = false)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.GET.class, View.ControllerView.PUT.class,
			View.ControllerView.Public.class })
	private String complemento;

	@Schema(description = "Usuário do Endereço", required = false)
	@JsonView(value = { View.ControllerView.GET.class, View.ControllerView.Internal.class })
	private UsuarioDTO usuario;

	public EnderecoDTO() {
		super();
	}

	public int getCodEndereco() {
		return codEndereco;
	}

	public void setCodEndereco(int codEndereco) {
		this.codEndereco = codEndereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

}
