package br.atos.xlo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CATEGORIA")
public class Categoria implements Serializable {

	private static final long serialVersionUID = 7863930352558641012L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "NI_COD_CATEGORIA")
	private int codigoCategoria;

	@Column(name = "VC_DESC_CATEGORIA")
	private String descricaoCategoria;

	public Categoria() {
		super();
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

	@Override
	public String toString() {
		return "Categoria [codigoCategoria=" + codigoCategoria + ", descricaoCategoria=" + descricaoCategoria + "]";
	}

}
