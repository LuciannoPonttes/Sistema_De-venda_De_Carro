package br.atos.xlo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_MODELO")
public class Modelo implements Serializable {

	private static final long serialVersionUID = -523272805108378276L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "NI_COD_MODELO")
	private int codigoModelo;

	@Column(name = "VC_DESC_MODELO")
	private String descricaoModelo;

	public Modelo() {
		super();
	}

	public int getCodigoModelo() {
		return codigoModelo;
	}

	public void setCodigoModelo(int codigoModelo) {
		this.codigoModelo = codigoModelo;
	}

	public String getDescricaoModelo() {
		return descricaoModelo;
	}

	public void setDescricaoModelo(String descricaoModelo) {
		this.descricaoModelo = descricaoModelo;
	}

	@Override
	public String toString() {
		return "Modelo [codigoModelo=" + codigoModelo + ", descricaoModelo=" + descricaoModelo + "]";
	}

}
