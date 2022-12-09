package br.atos.xlo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_LOGIN")
public class Login implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name = "VC_USUARIO", referencedColumnName = "VC_EMAIL")
	private Usuario usuario;

	@Column(name = "VC_SENHA")
	private String senha;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
