package br.atos.xlo.dto;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import br.atos.xlo.controller.dto.base.View;
import br.atos.xlo.controller.dto.base.response.Body;
import br.atos.xlo.enums.StatusUsuarioEnum;
import io.swagger.v3.oas.annotations.media.Schema;

public class UsuarioDTO implements Body {

	@Schema(description = "Código do Usuário", example = "1", required = false)
	@JsonView(value = { View.ControllerView.GET.class, View.ControllerView.PUT.class,
			View.ControllerView.Public.class })
	private int codUsuario;

	@Schema(description = "Roles do Usuário", required = false)
	@JsonView(value = { View.ControllerView.GET.class, View.ControllerView.Internal.class })
	private List<RoleDTO> roles;

	@Schema(description = "Endereço do Usuário", required = false)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.PUT.class, View.ControllerView.GET.class,
			View.ControllerView.Public.class })
	@Valid
	private EnderecoDTO endereco;

	@Schema(description = "Nome do Usuário", example = "João", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.PUT.class, View.ControllerView.GET.class,
			View.ControllerView.Public.class })
	@NotNull
	@NotBlank
	private String nome;

	@Schema(description = "CPF do Usuário", example = "'11111111111'", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.GET.class, View.ControllerView.PUT.class,
			View.ControllerView.Public.class })
	@NotNull
	@NotBlank
	private String cpf;

	@Schema(description = "E-mail do Usuário", example = "joao@xlo.com.br", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.PUT.class, View.ControllerView.GET.class,
			View.ControllerView.Public.class })
	@NotNull
	@NotBlank
	private String email;

	@JsonView(value = { View.ControllerView.POST.class })
	private LoginDTO login;

	@Schema(description = "Status do Usuário", example = "1", required = false)
	@JsonView(value = { View.ControllerView.GET.class, View.ControllerView.Public.class })
	private StatusUsuarioEnum statusUsuario;

	@Schema(description = "Data de cadastro do Usuário", example = "1099-01-01T00:00:00.000Z", required = true)
	@JsonView(value = { View.ControllerView.GET.class, View.ControllerView.Public.class })
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Date dtCadastro;

	@Schema(description = "Data de atualização do Usuário", example = "1099-01-01T00:00:00.000Z", required = true)
	@JsonView(value = { View.ControllerView.GET.class, View.ControllerView.Internal.class })
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Date dtAtualizacao;


	public UsuarioDTO() {
		super();
	}

	public int getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	public List<RoleDTO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDTO> roles) {
		this.roles = roles;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public StatusUsuarioEnum getStatusUsuario() {
		return statusUsuario;
	}

	public void setStatusUsuario(StatusUsuarioEnum statusUsuario) {
		this.statusUsuario = statusUsuario;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public Date getDtAtualizacao() {
		return dtAtualizacao;
	}

	public void setDtAtualizacao(Date dtAtualizacao) {
		this.dtAtualizacao = dtAtualizacao;
	}

	public LoginDTO getLogin() {
		return login;
	}

	public void setLogin(LoginDTO login) {
		this.login = login;
	}

}
