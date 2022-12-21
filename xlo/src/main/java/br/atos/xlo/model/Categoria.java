package br.atos.xlo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TB_CATEGORIA", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "NI_COD_CATEGORIA", "VC_DESC_CATEGORIA" }) })
public class Categoria implements Serializable {

	private static final long serialVersionUID = 7863930352558641012L;

	@Id
	@Column(name = "NI_COD_CATEGORIA")
	private int codigoCategoria;

	@Column(name = "VC_DESC_CATEGORIA")
	private String descricaoCategoria;

	public Categoria() {
		super();
	}

	public Categoria(int codigoCategoria, String descricaoCategoria) {
		super();
		this.codigoCategoria = codigoCategoria;
		this.descricaoCategoria = descricaoCategoria;
	}

	public int getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(int codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}

}
