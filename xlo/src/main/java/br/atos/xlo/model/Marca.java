package br.atos.xlo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_MARCA")
public class Marca implements Serializable {

	private static final long serialVersionUID = 6143325443129902023L;

	@Id
	@Column(name = "NI_COD_MARCA")
	private int codigoMarca;

	@Column(name = "VC_DESC_MARCA")
	private String descricaoMarca;

	public Marca() {
		super();
	}

	public Marca(int codigoMarca, String descricaoMarca) {
		super();
		this.codigoMarca = codigoMarca;
		this.descricaoMarca = descricaoMarca;
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

}
