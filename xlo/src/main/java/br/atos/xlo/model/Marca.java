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
@Table(name = "TB_MARCA", uniqueConstraints = { @UniqueConstraint(columnNames = { "NI_COD_MARCA", "VC_DESC_MARCA" }) })
public class Marca implements Serializable {

	private static final long serialVersionUID = 6143325443129902023L;

	@Id
	@Column(name = "NI_COD_MARCA")
	private int codigoMarca;

	@Column(name = "VC_DESC_MARCA")
	private String descricaoMarca;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "NI_COD_CATEGORIA", referencedColumnName = "NI_COD_CATEGORIA")
	private Categoria categoria;

	public Marca() {
		super();
	}

	public Marca(int codigoMarca, String descricaoMarca) {
		super();
		this.codigoMarca = codigoMarca;
		this.descricaoMarca = descricaoMarca;
	}

	public Marca(int codigoMarca, String descricaoMarca, Categoria categoria) {
		super();
		this.codigoMarca = codigoMarca;
		this.descricaoMarca = descricaoMarca;
		this.categoria = categoria;
	}

	public int getCodigoMarca() {
		return codigoMarca;
	}

	public void setCodigoMarca(int codigoMarca) {
		this.codigoMarca = codigoMarca;
	}

	public String getDescricaoMarca() {
		return descricaoMarca;
	}

	public void setDescricaoMarca(String descricaoMarca) {
		this.descricaoMarca = descricaoMarca;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
