package br.atos.xlo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_MODELO")
public class Modelo implements Serializable {

	private static final long serialVersionUID = -523272805108378276L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NI_COD_MODELO")
	private int codigoModelo;

	@Column(name = "VC_DESC_MODELO")
	private String descricaoModelo;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "NI_COD_MARCA", referencedColumnName = "NI_COD_MARCA")
	private Marca marca;

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Modelo() {
		super();
	}

	public Modelo(int codigoModelo, String descricaoModelo, Marca marca) {
		super();
		this.codigoModelo = codigoModelo;
		this.descricaoModelo = descricaoModelo;
		this.marca = marca;
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

}
