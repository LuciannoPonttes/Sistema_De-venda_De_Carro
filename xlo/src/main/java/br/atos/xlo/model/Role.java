package br.atos.xlo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ROLE")
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "NI_COD_ROLE")
	private int codRole;

	@Column(name = "VC_ROLE")
	private String role;

	public int getCodRole() {
		return codRole;
	}

	public void setCodRole(int codRole) {
		this.codRole = codRole;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
