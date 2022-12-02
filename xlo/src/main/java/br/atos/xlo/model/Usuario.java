package br.atos.xlo.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;

@Entity(name = "TB_USUARIO")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "NI_COD_USUARIO")
	private int codUsuario;
	
	@ManyToMany(mappedBy="usuarios")
	private List<Role> roles;
	
	@ManyToOne
	private List<Endereco> enderecos;
	
	@Column(name = "VC_NOME")
	private String nome;
	@Column(name = "VC_CPF")
	private String cpf;
	@Column(name = "VC_EMAIL")
	private String email;
	@Column(name = "VC_SENHA")
	private String senha;
	@Column(name = "NI_STATUS")
	private int statusUsuario;
	@Column(name = "DTH_CADASTRO")
	private Date dtCadastro;
	@Column(name = "DTH_ATUALIZACAO")
	private Date dtAtualizacao;
	
	public int getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
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
