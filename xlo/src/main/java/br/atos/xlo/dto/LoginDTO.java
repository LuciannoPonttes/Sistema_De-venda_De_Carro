package br.atos.xlo.dto;

import com.fasterxml.jackson.annotation.JsonView;

import br.atos.xlo.controller.dto.base.View;
import br.atos.xlo.model.Usuario;
import io.swagger.v3.oas.annotations.media.Schema;

public class LoginDTO {

	@Schema(description = "ID do login de Usuário", example = "1", required = false)
	@JsonView(value = { View.ControllerView.Internal.class })
	private int codLogin;

	@JsonView(value = { View.ControllerView.Internal.class })
	private Usuario usuario;

	@Schema(description = "Nome de Usuário", example = "joao@xlo.com.br", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.Internal.class })
	private String nomeUsuario;

	@Schema(description = "Senha do Usuário", example = "'123456'", required = true)
	@JsonView(value = { View.ControllerView.POST.class })
	private String senha;

	public int getCodLogin() {
		return codLogin;
	}

	public void setCodLogin(int codLogin) {
		this.codLogin = codLogin;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
