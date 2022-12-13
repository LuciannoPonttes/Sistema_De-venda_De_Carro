package br.atos.xlo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import br.atos.xlo.dto.enums.StatusUsuarioEnum;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "NI_COD_USUARIO")
	private int codUsuario;

	@ManyToMany
	@JoinTable(name = "TB_ROLE_USUARIO", joinColumns = @JoinColumn(name = "NI_COD_USUARIO", referencedColumnName = "NI_COD_USUARIO"), inverseJoinColumns = @JoinColumn(name = "NI_COD_ROLE", referencedColumnName = "NI_COD_ROLE"))
	private List<Role> roles = new ArrayList<>();

	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	private Endereco endereco;

	@OneToMany(mappedBy = "usuario")
	private Set<Veiculo> veiculo;

	@Column(name = "VC_NOME")
	private String nome;
	@Column(name = "VC_CPF")
	private String cpf;
	@Column(name = "VC_EMAIL")
	private String email;
	@Column(name = "NI_STATUS")
	private StatusUsuarioEnum statusUsuario;
	@Column(name = "DTH_CADASTRO", nullable = false, updatable = false)
	@CreationTimestamp
	private Date dtCadastro;
	@Column(name = "DTH_ATUALIZACAO")
	private Date dtAtualizacao;

	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	private Login login;

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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Set<Veiculo> getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Set<Veiculo> veiculo) {
		this.veiculo = veiculo;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

}
