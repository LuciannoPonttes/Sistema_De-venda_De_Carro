package br.atos.xlo.dto;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

import br.atos.xlo.controller.dto.base.View;
import io.swagger.v3.oas.annotations.media.Schema;

public class UsuarioDTO {

	@Schema(description = "Código do Usuário", example = "1", required = false)
	@JsonView(value = { View.ControllerView.GET.class, View.ControllerView.PUT.class })
	private int codUsuario;

	@JsonView(value = { View.ControllerView.GET.class })
	private List<RoleDTO> roles;

	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.PUT.class, View.ControllerView.GET.class })
	@Valid
	private EnderecoDTO endereco;

	@Schema(description = "Nome do Usuário", example = "João", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.PUT.class, View.ControllerView.GET.class })
	@NotNull
	@NotBlank
	private String nome;

	@Schema(description = "CPF do Usuário", example = "11111111111", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.GET.class })
	@NotNull
	@NotBlank
	private String cpf;

	@Schema(description = "E-mail do Usuário", example = "joao@xlo.com.br", required = true)
	@JsonView(value = { View.ControllerView.POST.class, View.ControllerView.PUT.class, View.ControllerView.GET.class })
	@NotNull
	@NotBlank
	private String email;

	@Schema(description = "Senha do Usuário", example = "123456", required = true)
	@JsonView(value = { View.ControllerView.POST.class })
	@NotNull
	@NotBlank
	private String senha;

	@JsonView(value = { View.ControllerView.GET.class })
	private int statusUsuario;

	@JsonView(value = { View.ControllerView.GET.class })
	private Date dtCadastro;

	@JsonView(value = { View.ControllerView.GET.class })
	private Date dtAtualizacao;

	@JsonView(value = { View.ControllerView.GET.class })
	private Set<VeiculoDTO> veiculo;

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

	public Set<VeiculoDTO> getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Set<VeiculoDTO> veiculo) {
		this.veiculo = veiculo;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getStatusUsuario() {
		return statusUsuario;
	}

	public void setStatusUsuario(int statusUsuario) {
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

}
