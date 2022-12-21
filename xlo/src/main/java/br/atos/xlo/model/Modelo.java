package br.atos.xlo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TB_MODELO", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "NI_COD_MODELO", "VC_DESC_MODELO", "NI_COD_MARCA" }) })
public class Modelo implements Serializable {

	private static final long serialVersionUID = -523272805108378276L;

	@Id
	@Column(name = "NI_COD_MODELO")
	private int codigoModelo;

	@Column(name = "VC_DESC_MODELO")
	private String descricaoModelo;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "NI_COD_CATEGORIA", referencedColumnName = "NI_COD_CATEGORIA")
	private Categoria categoria;

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

	public Modelo(int codigoModelo, String descricaoModelo) {
		super();
		this.codigoModelo = codigoModelo;
		this.descricaoModelo = descricaoModelo;
	}

	public Modelo(int codigoModelo, String descricaoModelo, Marca marca) {
		super();
		this.codigoModelo = codigoModelo;
		this.descricaoModelo = descricaoModelo;
		this.marca = marca;
	}

	public Modelo(int codigoModelo, String descricaoModelo, Categoria categoria, Marca marca) {
		super();
		this.codigoModelo = codigoModelo;
		this.descricaoModelo = descricaoModelo;
		this.categoria = categoria;
		this.marca = marca;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
